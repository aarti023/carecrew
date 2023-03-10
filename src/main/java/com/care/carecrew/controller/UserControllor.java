package com.care.carecrew.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.care.carecrew.dto.ResponseDto;
import com.care.carecrew.dto.UserDto;
import com.care.carecrew.model.User;
import com.care.carecrew.service.impl.UserServiceImpl;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/carecrew")
@Log4j2
//@CrossOrigin( origins = {},methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public class UserControllor {

	@Autowired
	private UserServiceImpl carecrewServiceImpl;

	
	@PostMapping("/save")
	@ApiOperation("save user details")
	public ResponseDto<User> saveDetail(@Valid @RequestBody UserDto userDto) {
		try {
			log.info("user {}", userDto);
			User response = carecrewServiceImpl.save(userDto);
			return ResponseDto.success("user details saved successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while saving the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while saving the data " + errorMessage);
		}
	}

//	@GetMapping("/get/data/{id}")
//	@ApiOperation("get detials by id")
//	public ResponseDto<User> getDetails(@PathVariable("id") Long id) {
//		try {
//			log.info("user {}", id);
//			User response = carecrewServiceImpl.getSavedDataById(id);
//			return ResponseDto.success("user details get successfully", response);
//		} catch (Exception errorMessage) {
//			log.error("Exception occurred while getting the data is {}", errorMessage);
//			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
//		}
//	}

	@GetMapping("/get/data/")
	@ApiOperation("get all details")
	public ResponseDto<List<User>> getAllDetails() {
		try {
			log.info("user {}");
			List<User> response = carecrewServiceImpl.getAllUserDetails();
			return ResponseDto.success("All User details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}
	}

}
