package com.care.carecrew.service;

import java.util.List;

import com.care.carecrew.dto.UserDto;
import com.care.carecrew.model.User;

public interface UserService {

	User save(UserDto user);
	
	List<User> getAllUserDetails();

	User getSavedDataById(Long id);
}
