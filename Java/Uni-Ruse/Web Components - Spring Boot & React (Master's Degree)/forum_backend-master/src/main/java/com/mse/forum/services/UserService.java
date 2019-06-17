package com.mse.forum.services;

import java.util.List;

import com.mse.forum.dto.UserDTO;

public interface UserService {
	boolean saveUser(UserDTO user);
	UserDTO getUser(UserDTO user);
	Integer getNumberOfUsers();
	List<UserDTO> getListOfModerators();
	List<UserDTO> getListOfAdmins();
}