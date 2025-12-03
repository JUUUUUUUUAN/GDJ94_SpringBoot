package com.winter.app.users;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDAO {
	
	public int register(UserDTO usersDTO) throws Exception;
	
	public void fileAdd(UserFileDTO userFileDTO) throws Exception;
	
	public UserDTO detail(UserDTO userDTO) throws Exception;
}
