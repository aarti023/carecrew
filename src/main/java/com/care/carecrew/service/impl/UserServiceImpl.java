package com.care.carecrew.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.care.carecrew.dto.UserDto;
import com.care.carecrew.exception.ResourceNotFoundException;
import com.care.carecrew.model.User;
import com.care.carecrew.repo.UserRepo;
import com.care.carecrew.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo carecrewRepo;

	@Override

	public User save(UserDto userDto) {
		User user = new User();		
		BeanUtils.copyProperties(userDto, user);
		
		if (Objects.isNull(user.getPhoneNumber())) {
			throw new NotAcceptableStatusException("Please enter mobile number");
		} 
		else if (!user.getPhoneNumber().matches("[0-9]+")) {
			throw new NotAcceptableStatusException("Not a valid mobile number");
		}
		carecrewRepo.save(user);
		return user;
	}

	@Override
	public User getSavedDataById(Long id) {

		return carecrewRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	}

	@Override
	public List<User> getAllUserDetails() {

		return carecrewRepo.findAll();
	}


}
