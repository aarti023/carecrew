package com.care.carecrew.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.carecrew.dto.CityDto;
import com.care.carecrew.model.CityEntity;
import com.care.carecrew.repo.CitiesRepo;
import com.care.carecrew.service.CityService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CitiesRepo citiesRepo;

	@Override
	public CityEntity save(CityDto cityDto) {
		CityEntity city = new CityEntity();
		BeanUtils.copyProperties(cityDto, city);

		citiesRepo.save(city);
		log.info("Created city with this  id: "+ city.getId());

		return city;
	}

	@Override
	public List<CityEntity> getAllCities() {

		return citiesRepo.findAll();
	}


}
