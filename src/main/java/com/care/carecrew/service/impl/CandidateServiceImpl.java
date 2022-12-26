package com.care.carecrew.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.care.carecrew.model.CandidateEntity;
import com.care.carecrew.repo.CandidateRepo;
import com.care.carecrew.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepo candidateRepo;

	@Override
	public CandidateEntity saveCandidate(CandidateEntity candidateEntity) {
		if (candidateEntity.getPhoneNumber().isBlank()) {
			throw new NotAcceptableStatusException("Please enter mobile number");
		} else if (!candidateEntity.getPhoneNumber().matches("[0-9]+")) {
			throw new NotAcceptableStatusException("Not a valid mobile number");
		}

		CandidateEntity save = candidateRepo.save(candidateEntity);
		return save;
	}

	@Override
	public List<CandidateEntity> getAllDetais() {

		return candidateRepo.findAll();
	}

}
