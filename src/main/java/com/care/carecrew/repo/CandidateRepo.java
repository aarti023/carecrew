package com.care.carecrew.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.care.carecrew.model.CandidateEntity;

@Repository
public interface CandidateRepo extends JpaRepository<CandidateEntity, Long>  {

	CandidateEntity save(Optional<CandidateEntity> candidate);

}

