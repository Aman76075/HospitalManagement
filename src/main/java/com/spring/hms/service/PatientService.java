package com.spring.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hms.exception.InvalidCredentialsException;
import com.spring.hms.model.User;
import com.spring.hms.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	PatientRepository patientRepository;

	public User verifyLogin(String username, String password) throws InvalidCredentialsException {
		return patientRepository.verifyLogin(username,password);
	}
	

}
