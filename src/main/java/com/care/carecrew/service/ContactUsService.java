package com.care.carecrew.service;

import java.util.List;

import com.care.carecrew.dto.ContactUsDto;
import com.care.carecrew.model.ContactUs;

public interface ContactUsService {
	
//	ContactUs saveContactform (ContactUs contactUs);
	ContactUs save(ContactUsDto contactUsDto);
	
	List<ContactUs> getAllContactform();
	
}
