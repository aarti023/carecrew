package com.care.carecrew.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.care.carecrew.dto.UserDto;
import com.care.carecrew.exception.ResourceNotFoundException;
import com.care.carecrew.model.User;
import com.care.carecrew.repo.UserRepo;
import com.care.carecrew.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo carecrewRepo;

	@Override

	public User save(UserDto userDto) {
		User user = new User();
		String a = "[";
		BeanUtils.copyProperties(userDto, user);

		if (Objects.isNull(user.getPhoneNumber())) {
			throw new NotAcceptableStatusException("Please enter mobile number");
		} else if (!user.getPhoneNumber().matches("[0-9]+")) {
			throw new NotAcceptableStatusException("Not a valid mobile number");
		}
		for(String i : userDto.getService()) {
			a+=i+",";
		}
		a+="]";
		user.setService(a);
		carecrewRepo.save(user);
		log.info("Data of user: " + user.getName() + " is saved");
		return user;
	}

	@Override
	public User getSavedDataById(Long id) {
		Optional<User> user = carecrewRepo.findById(id);

		if (Objects.isNull(user)) {

			throw new NotAcceptableStatusException("User Not Found with id: " + id);
		}

		log.info("User Found: " + user);

		return carecrewRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	}

	@Override
	public List<User> getAllUserDetails() {
		if (Objects.isNull(User.class)) {

			throw new NotAcceptableStatusException("User Not Found with id: ");
		}
		return carecrewRepo.findAll();
	}

}
