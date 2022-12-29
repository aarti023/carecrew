package com.care.carecrew.dto;

import java.util.ArrayList;
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
public class UserDto {

	private String name;

	private String email;

	private String phoneNumber;

	private String address;

	private String message;

	private String workingHours;

	private String city;

	private ArrayList<String> service;

	private String locality;

	private Date createdAt;

	private String localityOthers;

	private String cityOthers;
}
