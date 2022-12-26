package com.care.carecrew.dto;

import java.util.Date;

import com.care.carecrew.model.CityEntity;
import com.care.carecrew.model.LocalityEntity;

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
public class UserDto {

	private Long id;

	private String name;

	private String email;

	private String phoneNumber;

	private String address;

	private String message;

	private String workingHours;

	private CityEntity cities;
	
	private LocalityEntity locality;

	private Date createdAt;

//	private Service service;
	
//	private Cities cities;
//
//	private Locality locality;
	
}
