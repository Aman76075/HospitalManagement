<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="com.spring.hms.model.Appointment" %>
 <html>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<body >
		<%
		List<Appointment> allAppointment = (List<Appointment>) request.getAttribute("allAppointment"); 
			
						
		%>
	       <div class="container-fluid" style="margin: 0%; padding: 0px;">
	           <div class="row">
	               <div class="col-lg-12">
					<%@ include file="navbar.jsp" %>	
	               </div>
	           </div>
	           <div class="row">
	               <div class="col-sm-2">sidebar goes here...</div>
	               <div class="col-md-10  mt-4">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="display-6">Book Appointment</h1>
							<hr>
							<div class="card-body">
													<form method="get" action="/book-appointment"> 						
													<label>Enter Doctor ID: </label>
													<input type="text" name="doctorId" class="form-control">
													 
													<label>Enter Date: </label>
													<input type="text" name="appointment_date" class="form-control">
													 
													<input type="submit" value="BOOK APPOINTMENT" class="btn btn-primary">
													</form>
												</div>
						</div>
					</div>
	                   <div class="row">
	                        
	                       <div class="col-lg-12">
							<h1 class="display-6">All  Appointment</h1>
	                           <table class="table">
	                               <thead>
	                                 <tr>
	                                   <th scope="col">#</th>
	                                   <th scope="col">Doctor ID</th>
	                                   <th scope="col">Appointment Date</th>
									   <th scope="col">Status</th>
	                                   <th scope="col">Actions</th>
	                                 </tr>
	                               </thead>
	                               <tbody>
									<% for( Appointment a:allAppointment){
										%>
										<tr>
										  <th scope="row"> <%=a.getId() %></th>
										  <td><%=a.getDoctor().getId() %></td>
										  <td><%=a.getAppointment_date() %></td>
										  <td><%=a.getStatus() %></td>
										  <td>
											
											<a href="<%=request.getContextPath() %>/cancel-appointment?aid=<%=a.getId() %>">Cancel</a>
										  </td>
										</tr>										
									<%	
									} 
									%>

	                                 
	                               </tbody>
	                             </table>
	                       </div>
	                   </div>
	               </div>
	           </div>
	       </div>
	   </body>
</html>	