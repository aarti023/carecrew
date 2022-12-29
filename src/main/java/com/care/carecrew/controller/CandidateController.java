package com.care.carecrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.carecrew.dto.CandidateDto;
import com.care.carecrew.dto.ResponseDto;
import com.care.carecrew.model.CandidateEntity;
import com.care.carecrew.service.impl.CandidateServiceImpl;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/candidate")
//@CrossOrigin( origins = {},methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public class CandidateController {

	@Autowired
	private CandidateServiceImpl candidateServiceImpl;

	@PostMapping(value = "/save")
	public ResponseDto<CandidateEntity> create(@RequestBody CandidateDto candidateDto) {

		log.info("Save details [" + candidateDto + "]");

		CandidateEntity response = candidateServiceImpl.save(candidateDto);

		return ResponseDto.success("save details Successfully", response);

	}

	@GetMapping("/get/candidates/")
	public ResponseDto<List<CandidateEntity>> getDetails() {
		try {
			log.info("user {}");
			List<CandidateEntity> response = candidateServiceImpl.getAllDetais();
			return ResponseDto.success("All candates details get successfully", response);
		} catch (Exception errorMessage) {
			log.error("Exception occurred while getting the data is {}", errorMessage);
			return ResponseDto.failure("Exception occurred while getting the data " + errorMessage);
		}

	}
}
