package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Value("${app.upload.user}")
	private String uploadPath;
	
	public boolean getError(UserDTO userDTO, BindingResult bindingResult) throws Exception {
		//check : true -> 검증 실패, error 존재
		//check : false -> 검증 성공, error 존재 X
		//1. annotation 검증 결과
		boolean check = bindingResult.hasErrors();
		
		//2. password 일치하는 지 검증
		if(!userDTO.getPassword().equals(userDTO.getPasswordCheck())) {
			check = true;
			//bindingResult.rejectValue("멤버변수명", "properties의 키");
			bindingResult.rejectValue("passwordCheck", "user.password.equal");
		}
		
		//3. ID 중복 체크
		if(userDTO.getUsername() != null) {
			UserDTO checkDTO = userDAO.detail(userDTO);
			if(checkDTO != null) {
				bindingResult.rejectValue("username", "user.username.duplication");
			}			
		}
		
		return check;
	}
	
	public int register(UserDTO userDTO) throws Exception {
		return userDAO.register(userDTO);
	}
	
	public void fileAdd(UserFileDTO userFileDTO) throws Exception{
		userDAO.fileAdd(userFileDTO);
	}
	
	public UserDTO detail(UserDTO userDTO) throws Exception {
		UserDTO loginDTO =  userDAO.detail(userDTO);

		if(loginDTO != null) {
			if (loginDTO.getPassword().equals(userDTO.getPassword())) {
				return loginDTO;
			} else {
				loginDTO = null;
			}
		}

		return loginDTO;
	}
	
	public int update(UserDTO userDTO) throws Exception {
		return userDAO.update(userDTO);
	}
	
}
