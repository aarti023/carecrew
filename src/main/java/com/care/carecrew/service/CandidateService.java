package com.care.carecrew.service;

import java.util.List;

import com.care.carecrew.model.CandidateEntity;

public interface CandidateService {
	
	public CandidateEntity saveCandidate(CandidateEntity candidateEntity);

	List<CandidateEntity> getAllDetais();

}
