package com.spring.hms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import com.spring.hms.model.Appointment;
import com.spring.hms.repository.AppointmentRepository;
import com.spring.hms.repository.PatientRepository;
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
	public List<Appointment> getAllAppointment(Object object) {
		String username = (String) object;
		return appointmentRepository.fetchAllAppointment(username);

		
	}
	public void cancelAppointment(String aid) {
		appointmentRepository.cancelAppointment(Integer.parseInt(aid));
		
	}
	public void bookAppointment(String username, String appointment_date, int doctor_id) {
		int pid=patientRepository.getIdByUsername(username);
		appointmentRepository.bookAppointment(pid,appointment_date,doctor_id);
		
	}

}
