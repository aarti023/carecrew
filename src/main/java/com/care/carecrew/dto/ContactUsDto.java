package com.care.carecrew.dto;

import java.util.Date;

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
public class ContactUsDto {
	
	private String name;

	private String email;

	private String phoneNumber;

	private String address;

	private String city;

	private String message;

	private String workingHours;

	private Date createdAt;

}
