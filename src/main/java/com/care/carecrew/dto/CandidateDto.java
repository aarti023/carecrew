package com.care.carecrew.dto;

import com.care.carecrew.model.CityEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDto {
	
	private Long id;
	
	private String name;
	
	private String phoneNumber;
	
	private CityEntity cities;

}
