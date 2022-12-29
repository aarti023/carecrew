package com.care.carecrew.dto;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;

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
	
	private String name;
	
	private String phoneNumber;
	
	private String city;
	
	private ArrayList<String> services;
	
	private String localityOthers;
	
	private String cityOthers;
	
	private Date createdAt; 

}
