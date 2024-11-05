package com.spring.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.hms.exception.InvalidCredentialsException;
import com.spring.hms.model.Appointment;
import com.spring.hms.model.User;
import com.spring.hms.service.AppointmentService;
import com.spring.hms.service.PatientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("/")
	public String showLogin() {
		return "login";
	}

	@GetMapping("/login-form")
	public String handleLogin(HttpServletRequest req,HttpSession session) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			User user = patientService.verifyLogin(username, password);
			if (user.getRole().equalsIgnoreCase("patient")) {
				session.setAttribute("username", username);
				List<Appointment>allAppointment=appointmentService.getAllAppointment(session.getAttribute("username"));
				req.setAttribute("allAppointment", allAppointment);
				return "patientDashboard";
			}
		} catch (InvalidCredentialsException e) {
			req.setAttribute("msg", e.getMessage());
			return "login";
		}
		return null;

	}
	@GetMapping("/patientDashboard")
	public String goToPatientDashboard(HttpServletRequest req,HttpSession session) {
		List<Appointment>allAppointment=appointmentService.getAllAppointment(session.getAttribute("username"));
		req.setAttribute("allAppointment", allAppointment);
		return "patientDashboard";
	}
	
	@GetMapping("/cancel-appointment")
	public String cancelAppointment(HttpServletRequest req) {
		String aid=req.getParameter("aid");
		appointmentService.cancelAppointment(aid);
		return "redirect:/patientDashboard";
		
	}
	@GetMapping("/book-appointment")
	public String bookAppointment(HttpServletRequest req,HttpSession session) {
		String username=(String)session.getAttribute("username");
		String appointment_date=req.getParameter("appointment_date");
		int doctor_id=Integer.parseInt(req.getParameter("doctorId"));
		appointmentService.bookAppointment(username,appointment_date,doctor_id);
		req.setAttribute("appointment_date", appointment_date);
		req.setAttribute("doctorId", doctor_id);
		return "appointment_confirm";
	}
	
	
}
