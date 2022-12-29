package com.care.carecrew.service;

import java.util.List;

import com.care.carecrew.dto.LocalityDto;
import com.care.carecrew.model.LocalityEntity;

public interface LocalityService {
	
	LocalityEntity save(LocalityDto localityDto);

	List<LocalityEntity> getAllLocalities();

}
