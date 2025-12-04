package com.winter.app.users;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.winter.app.board.notice.NoticeService;
import com.winter.app.files.FileManager;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users/*")
public class UserController {

    private final NoticeService noticeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.user}")
	private String uploadPath;

    UserController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
	
	@GetMapping("register")
	public void register(UserDTO userDTO) {}
	
	@PostMapping("register")
	public String register(@Validated(RegisterGroup.class) UserDTO userDTO,BindingResult bindingResult, MultipartFile img) throws Exception {
		
		if(userService.getError(userDTO, bindingResult)) {
			return "/users/register";
		}
		
		userService.register(userDTO);
		
		File file = new File(uploadPath);
		
		UserFileDTO userFileDTO = new UserFileDTO();
		System.out.println(img.toString());
		String fileName = fileManager.fileSave(file, img);
		userFileDTO.setFileName(fileName);
		userFileDTO.setFileOrigin(img.getOriginalFilename());
		userFileDTO.setUsername(userDTO.getUsername());
		userService.fileAdd(userFileDTO);
		return "redirect:/";
	}
	
	@GetMapping("mypage")
	public void detail() throws Exception {
	}
		
	@GetMapping("login")
	public void login() throws Exception {}
	
	@PostMapping("login")
	public String login(UserDTO userDTO, HttpSession session) throws Exception{
		userDTO = userService.detail(userDTO);
		
		session.setAttribute("user", userDTO);
		return "redirect:/";
	}
	
	@GetMapping("update")
	public void update(HttpSession session, Model model) throws Exception {
		// 정보 수정시 기존의 유저 정보를 보여주어야하니 세션에 저장된 유저 정보를 전달한다.
		model.addAttribute("userDTO", session.getAttribute("user"));
	}
	
	@PostMapping("update")
	public String update(@Validated(UpdateGroup.class) UserDTO userDTO, BindingResult bindingResult, HttpSession session) throws Exception {
		if(bindingResult.hasErrors()) {
			return "users/update";
		} 
		// 수정할 정보를 받은 경우 세션에 있는 정보와 수정된 정보가 다르다
		// 1. 세션에 있는 정보를 가져온다(username이 없기때문에 => 수정된 정보는 이름, 이메일, 전화번호, 생년월일만 수정 가능)
		UserDTO loginDTO = (UserDTO) session.getAttribute("user");
		// 2. 전달받은 객체(username없음)에 username만 추가하여 정보 업데이트 진행
		userDTO.setUsername(loginDTO.getUsername());
		int result = userService.update(userDTO);
		
		if(result > 0) {
			// 3. 새로 업데이트 되었으면 새로 업데이트된 정보로 다시 세션에 전달하기
			loginDTO = userService.detail(loginDTO);
			session.setAttribute("user", loginDTO);
		}
		return "redirect:./mypage";
	}
	
	@GetMapping("change")
	public void change(UserDTO userDTO) throws Exception {
		
	}
	
	@PostMapping("change")
	public String change(@Validated(PasswordGroup.class) UserDTO userDTO,BindingResult bindingResult, String exist) throws Exception {
		
		if(userService.getError(userDTO, bindingResult)) {
			return "users/change";
		}
		return "redirect:./mypage";
	}
}
