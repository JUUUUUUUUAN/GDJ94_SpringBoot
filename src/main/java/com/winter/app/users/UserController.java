package com.winter.app.users;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.files.FileManager;

@Controller
@RequestMapping("/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.user}")
	private String uploadPath;
	
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(UserDTO userDTO, MultipartFile img) throws Exception {
		userService.register(userDTO);
		
		File file = new File(uploadPath);
		
		UserFileDTO userFileDTO = new UserFileDTO();
		String fileName = fileManager.fileSave(file, img);
		userFileDTO.setFileName(fileName);
		userFileDTO.setFileOrigin(img.getOriginalFilename());
		userFileDTO.setUsername(userDTO.getUsername());
		userService.fileAdd(userFileDTO);
		return "redirect:/notice/list";
	}
	
	@GetMapping("mypage")
	public void detail() throws Exception {
		
	}
}
