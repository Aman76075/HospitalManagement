package com.spring.hms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.hms.model.Appointment;
import com.spring.hms.model.Doctor;
import com.spring.hms.model.Patient;
@Repository
public class AppointmentRepository {
	@Autowired
	private JdbcTemplate jdbc;

	public List<Appointment> fetchAllAppointment(String username) {
		String sql="select a.* from appointment a join patient p on a.patient_id=p.id join user u on p.user_id=u.id where u.username=?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt =  con.prepareStatement(sql);
				pstmt.setString(1, username);
				return pstmt;
			}
			
		};
		RowMapper<Appointment> rowMapper=new RowMapper<Appointment>() {
			
			@Override
			public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Appointment appointment=new Appointment();
				int appointmentId=rs.getInt("id");
				String appointment_date=rs.getString("appointment_date");
				int doctorId=rs.getInt("doctor_id");
				String status=rs.getString("status");
				int patientId=rs.getInt("patient_id");
				
				appointment.setAppointment_date(appointment_date);
				Doctor doc=new Doctor();
				doc.setId(doctorId);
				appointment.setDoctor(doc);
				Patient pat=new Patient();
				pat.setId(patientId);
				appointment.setPatient(pat);
				appointment.setId(appointmentId);
				appointment.setStatus(status);
				
				return appointment;
			}
			
		};
		List<Appointment>list=jdbc.query(psc,rowMapper);
		return list;	
	}

	public void cancelAppointment(int aid) {
		String sql="update appointment set status='cancelled' where id=?";
		PreparedStatementCreator psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt =  con.prepareStatement(sql);
				pstmt.setInt(1, aid);
				return pstmt;
			}
		};
		jdbc.update(psc);
		
	}
	

}
