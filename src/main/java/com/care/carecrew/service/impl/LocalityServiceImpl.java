package com.care.carecrew.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.care.carecrew.dto.LocalityDto;
import com.care.carecrew.exception.ResourceNotFoundException;
import com.care.carecrew.model.LocalityEntity;
import com.care.carecrew.model.User;
import com.care.carecrew.repo.LocalityRepo;
import com.care.carecrew.service.LocalityService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class LocalityServiceImpl implements LocalityService {

	@Autowired
	private LocalityRepo localityRepo;

	@Override
	public LocalityEntity save(LocalityDto localityDto) {
		LocalityEntity locality = new LocalityEntity();
		BeanUtils.copyProperties(localityDto, locality);

		localityRepo.save(locality);
		log.info("Created Locality with this  id: "+ locality.getId());
		return locality;
	}

	@Override
	public List<LocalityEntity> getAllLocalities() {
		
		return localityRepo.findAll();

	}

}
