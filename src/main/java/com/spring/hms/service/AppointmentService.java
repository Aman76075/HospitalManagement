package com.spring.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hms.model.Appointment;
import com.spring.hms.repository.AppointmentRepository;
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
	public List<Appointment> getAllAppointment(Object object) {
		String username = (String) object;
		return appointmentRepository.fetchAllAppointment(username);

		
	}
	public void cancelAppointment(String aid) {
		appointmentRepository.cancelAppointment(Integer.parseInt(aid));
		
	}

}
