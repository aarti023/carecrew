package com.care.carecrew.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", columnDefinition = "varchar(100)")
	private String name;

	@Column(name = "email", columnDefinition = "varchar(100)")
	private String email;

	@Column(name = "phone_number", columnDefinition = "varchar(15)")
	private String phoneNumber;

	@Column(name = "address", columnDefinition = "varchar(256)")
	private String address;

	@Column(name = "locality", columnDefinition = "varchar(256)")
	private String locality;
	
	@Column(name = "city", columnDefinition = "varchar(256)")
	private String city;

	@Column(name = "working_hours", columnDefinition = "varchar(100)")
	private String workingHours;

	@Column(name = "message", columnDefinition = "varchar(256)")
	private String message;

	@Column(name = "created_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = { "dd.MM.yyyy" })
	private Date createdAt;
	
	private ArrayList<String> service;
	
	@Column(name = "locality_others", columnDefinition = "varchar(100)")
	private String localityOthers;
	
	@Column(name = "city_others", columnDefinition = "varchar(100)")
	private String cityOthers;
}
