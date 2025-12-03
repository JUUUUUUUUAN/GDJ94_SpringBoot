package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
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
	
}
