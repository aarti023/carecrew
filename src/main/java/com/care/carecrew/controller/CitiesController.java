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

import com.care.carecrew.dto.CityDto;
import com.care.carecrew.dto.ResponseDto;
import com.care.carecrew.model.CityEntity;
import com.care.carecrew.service.CityService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/city")
//@CrossOrigin( origins = {},methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public class CitiesController {

	@Autowired
	private CityService cityService;

	@PostMapping(value = "/create")
	@ApiOperation("create city")
	public ResponseDto<CityEntity> create(@RequestBody CityDto cityDto) {

		Thread.currentThread().setName(UUID.randomUUID().toString());

		log.info("Create City [" + cityDto + "]");

		CityEntity response = cityService.save(cityDto);

		return ResponseDto.success("City Created Successfully", response);

	}

	@GetMapping("/get/cities/")
	@ApiOperation("get all cities")
	public ResponseDto<List<CityEntity>> getCities() {
		try {
			log.info("user {}");
			List<CityEntity> response = cityService.getAllCities();
			return ResponseDto.success("All Cities get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}

	}

}
