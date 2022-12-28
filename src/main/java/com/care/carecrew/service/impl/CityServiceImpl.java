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

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CitiesRepo citiesRepo;

	@Override
	public CityEntity save(CityDto cityDto) {
		CityEntity city = new CityEntity();
		BeanUtils.copyProperties(cityDto, city);

		citiesRepo.save(city);
		return city;
	}

	@Override
	public List<CityEntity> getAllCities() {

		return citiesRepo.findAll();
	}

	@Override
	public CityEntity saveCities(CityEntity cityEntity) {
		Optional<CityEntity> care = citiesRepo.findById(cityEntity.getId());
		CityEntity save = citiesRepo.save(cityEntity);
		return save;
	}

}
