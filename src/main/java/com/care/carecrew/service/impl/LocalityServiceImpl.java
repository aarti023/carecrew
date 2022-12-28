package com.care.carecrew.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.carecrew.dto.LocalityDto;
import com.care.carecrew.model.LocalityEntity;
import com.care.carecrew.repo.LocalityRepo;
import com.care.carecrew.service.LocalityService;

@Service
public class LocalityServiceImpl implements LocalityService {

	@Autowired
	private LocalityRepo localityRepo;

	@Override
	public LocalityEntity save(LocalityDto localityDto) {
		LocalityEntity locality = new LocalityEntity();
		BeanUtils.copyProperties(localityDto, locality);

		localityRepo.save(locality);
		return locality;
	}

	@Override
	public List<LocalityEntity> getAllLocalities() {
		return localityRepo.findAll();

	}

}
