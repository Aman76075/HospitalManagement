<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>	
<html>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body background="grey">
	<div class="container">
        <div class="row">
            <div class="col-lg-12">
                <%@ include file="navbar.jsp" %>	
            </div>
        </div>
        <div class="row mt-4">
            <div class="col.lg-12">
                <div class="p-5 mb-4 bg-light rounded-3">
                    <div class="container-fluid py-5">
                      <h1 class="display-5 fw-bold">Appointment Booking Confirmation</h1>
                      <p class="col-md-8 fs-4">
                        Dear <%=session.getAttribute("username") %>, <br>
                        Thank you for booking the appointment with Doctor id: <%=request.getAttribute("doctorId") %>
                        <br>
                        Your appointment is booked for: <%=request.getAttribute("appointment_date") %>
                      </p>
                      <a href="<%=request.getContextPath() %>/patientDashboard"> <button class="btn btn-primary btn-lg"   type="button">Go to Dashboard</button></a>
                    </div>
                  </div>
            </div>
        </div>
    </div>
</body>
</html>