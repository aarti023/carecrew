package com.care.carecrew.service;

import java.util.List;

import com.care.carecrew.dto.CityDto;
import com.care.carecrew.model.CityEntity;

public interface CityService {
	public CityEntity save(CityDto cityDto);
		
	List<CityEntity> getAllCities();

}
