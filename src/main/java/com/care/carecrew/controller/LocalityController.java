package com.care.carecrew.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.care.carecrew.dto.LocalityDto;
import com.care.carecrew.dto.ResponseDto;
import com.care.carecrew.model.LocalityEntity;
import com.care.carecrew.service.LocalityService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/Society")
@Log4j2
//@CrossOrigin( origins = {},methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public class LocalityController {

	@Autowired 
	private LocalityService localityService;
	
	@PostMapping(value = "/create")
	@ApiOperation("create society")
	public ResponseDto<LocalityEntity> create(@RequestBody LocalityDto localityDto) {

		Thread.currentThread().setName(UUID.randomUUID().toString());

		log.info("Create society [" + localityDto + "]");

		LocalityEntity response = localityService.save(localityDto);

		return ResponseDto.success("society Created Successfully", response);

	}

	@GetMapping("/get/societies/")
	@ApiOperation("get all society")
	public ResponseDto<List<LocalityEntity>> getSociety() {
		try {
			log.info("user {}");
			List<LocalityEntity> response = localityService.getAllLocalities();
			return ResponseDto.success("Get all Society successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}

	}
}
