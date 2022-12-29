package com.care.carecrew.service;

import java.util.List;

import com.care.carecrew.dto.CandidateDto;
import com.care.carecrew.model.CandidateEntity;

public interface CandidateService {
	
	public CandidateEntity save(CandidateDto candidateDto);

	List<CandidateEntity> getAllDetais();

}
