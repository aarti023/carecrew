package com.care.carecrew.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.care.carecrew.dto.CandidateDto;
import com.care.carecrew.dto.ContactUsDto;
import com.care.carecrew.model.CandidateEntity;
import com.care.carecrew.model.ContactUs;
import com.care.carecrew.repo.ContactUsRepo;
import com.care.carecrew.service.ContactUsService;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired
	private ContactUsRepo contactUsRepo;

//	@Override
//	public ContactUs saveContactform(ContactUs contactUs) {
//		if (!contactUs.getName().matches("[a-zA-Z_]+")) {
//			throw new NotAcceptableStatusException("Not a valid user");
//		}
//
//		else if (Objects.isNull(contactUs.getPhoneNumber())) {
//			throw new NotAcceptableStatusException("Please enter mobile number");
//		} else if (!contactUs.getPhoneNumber().matches("[0-9]+")) {
//			throw new NotAcceptableStatusException("Not a valid mobile number");
//		}
//
//		ContactUs save = contactUsRepo.save(contactUs);
//		return save;
//
//	}
	
	@Override
	public ContactUs save(ContactUsDto contactUsDto) {
		ContactUs contact = new ContactUs();
		BeanUtils.copyProperties(contactUsDto, contact);
    
		if (Objects.isNull(contact.getPhoneNumber())) {
			throw new NotAcceptableStatusException("Please enter mobile number");
		} else if (!contact.getPhoneNumber().matches("[0-9]+")) {
			throw new NotAcceptableStatusException("Not a valid mobile number");
		}
		contactUsRepo.save(contact);
		return contact;
	}

	@Override
	public List<ContactUs> getAllContactform() {
		return contactUsRepo.findAll();
	}

}
