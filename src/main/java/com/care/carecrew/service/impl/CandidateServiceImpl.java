package com.care.carecrew.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.care.carecrew.dto.CandidateDto;
import com.care.carecrew.model.CandidateEntity;
import com.care.carecrew.repo.CandidateRepo;
import com.care.carecrew.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepo candidateRepo;

	@Override
	public CandidateEntity save(CandidateDto candidateDto) {
		CandidateEntity candidate = new CandidateEntity();
		BeanUtils.copyProperties(candidateDto, candidate);

		if (Objects.isNull(candidate.getPhoneNumber())) {
			throw new NotAcceptableStatusException("Please enter mobile number");
		} else if (!candidate.getPhoneNumber().matches("[0-9]+")) {
			throw new NotAcceptableStatusException("Not a valid mobile number");
		}
		candidateRepo.save(candidate);
		return candidate;
	}

	@Override
	public List<CandidateEntity> getAllDetais() {

		return candidateRepo.findAll();
	}

}
