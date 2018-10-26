<%@page import="java.util.ArrayList"%>
<%@page import="com.stayhealthy.appt.model.DrDetailsModel"%>
<%@page import="com.stayhealthy.appt.dao.AppointmentDAO"%>
<%@page import="com.stayhealthy.appt.model.AppointmentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Dr Details Page</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="footer, address, phone, icons" />
<link type="text/css" rel="stylesheet" href="css/body.css" />
<link type="text/css" rel="stylesheet" href="css/footer.css" />
<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet"
	href="css/footer-distributed-with-address-and-phones.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link href="http://fonts.googleapis.com/css?family=Cookie"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://mogulsdemo.com/html/pride-home/css/font-awesome.css">

<%@include file="header.jsp"%>
</head>

<body background="img/pic20.png">
	<div class="container">

		<div class="row setup-content" id="ProfileSetup-step">
			<div class="col-xs-12">
				<div class="col-md-12">
					<br />
					<div class="form-horizontal">
						<%
							ArrayList<DrDetailsModel> getDrDetails = (ArrayList<DrDetailsModel>) session.getAttribute("drDetails");

							if (getDrDetails != null)
								for (DrDetailsModel drModel : getDrDetails) {

									int drId = drModel.getpId();
									session.setAttribute("DrPrimaryId", drId);
						%>

						<center>
							<b style="font-size: 18pt; color: darkblue;">UPDATE DOCTOR
								DETAILS</b>
						</center>
						<br> <br>
						<div class="media">
							<center>
								<div class="media-left media-top">
									<img src="PhotoServlet?doctorid=<%=drModel.getpId()%>>"
										class="media-object" alt="Dr Picture"
										style="width: 250px; border: 2px solid black;">
								</div>
								<br>
								<div class="media-body">
									<h4 class="media-heading" style="color: black;">
										<b><%=drModel.getDrName()%></b>
									</h4>
								</div>
							</center>
						</div>
						<br> <br>
						<form
							action="<%=request.getContextPath()%>/UpdatingDrDetailsServlet"
							 method="post">
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Doctor
									Name:</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="drName" value="<%=drModel.getDrName()%>" />
								</div>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Appointment
									Day(If you want to change date then select, Otherwise this is
									already selected internally):</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="apptDay" value="<%=drModel.getAppointMentDay()%>" />
								</div>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Doctor
									Status:</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="drStatus" value="<%=drModel.getDrStatus()%>" />
								</div>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Specialization:
								</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="drSpecialization"
										value="<%=drModel.getSpecialization()%>" />
								</div>
							</div>

							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Location:</label>
								<%
									String drLocation = drModel.getDrChember();
											if (drLocation.equalsIgnoreCase("NewDelhi")) {
								%>
								<div class="col-sm-3">

									<label for="newDelhi">New Delhi</label> <input type="radio"
										name="location" id="newDelhi" value="NewDelhi" /> <label
										for="banglore">Banglore</label> <input type="radio"
										name="location" id="banglore" value="Banglore" /> <label
										for="kolkata">Kolkata</label> <input type="radio"
										name="location" id="kolkata" value="Kolkata" /> <label
										for="chennai">Chennai</label> <input type="radio"
										name="location" id="chennai" value="Chennai" />
								</div>
								<%
									} else if (drLocation.equalsIgnoreCase("Banglore")) {
								%>
								<label for="newDelhi">New Delhi</label> <input type="radio"
									name="location" id="newDelhi" value="NewDelhi" /> <label
									for="banglore">Banglore</label> <input type="radio"
									name="location" checked="checked" id="banglore"
									value="Banglore" /> <label for="kolkata">Kolkata</label> <input
									type="radio" name="location" id="kolkata" value="Kolkata" /> <label
									for="chennai">Chennai</label> <input type="radio"
									name="location" id="chennai" value="Chennai" />
								<%
									} else if (drLocation.equalsIgnoreCase("Kolkata")) {
								%>
								<label for="newDelhi">New Delhi</label> <input type="radio"
									name="location" id="newDelhi" value="NewDelhi" /> <label
									for="banglore">Banglore</label> <input type="radio"
									name="location" id="banglore" value="Banglore" /> <label
									for="kolkata">Kolkata</label> <input type="radio"
									name="location" checked="checked" id="kolkata" value="Kolkata" />
								<label for="chennai">Chennai</label> <input type="radio"
									name="location" id="chennai" value="Chennai" />
								<%
									} else if (drLocation.equalsIgnoreCase("Chennai")) {
								%>
								<label for="newDelhi">New Delhi</label> <input type="radio"
									name="location" id="newDelhi" value="NewDelhi" /> <label
									for="banglore">Banglore</label> <input type="radio"
									name="location" id="banglore" value="Banglore" /> <label
									for="kolkata">Kolkata</label> <input type="radio"
									name="location" id="kolkata" value="Kolkata" /> <label
									for="chennai">Chennai</label> <input type="radio"
									name="location" checked="checked" id="chennai" value="Chennai" />
								<%
									} else {
								%>
								<label for="newDelhi">New Delhi</label> <input type="radio"
									name="location" id="newDelhi" value="NewDelhi" /> <label
									for="banglore">Banglore</label> <input type="radio"
									name="location" id="banglore" value="Banglore" /> <label
									for="kolkata">Kolkata</label> <input type="radio"
									name="location" id="kolkata" value="Kolkata" /> <label
									for="chennai">Chennai</label> <input type="radio"
									name="location" id="chennai" value="Chennai" />
								<%
									}
								%>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Hospital
									Name: </label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="hospitalName" value="<%=drModel.getHospitalName()%>" />
								</div>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Doctor
									Language:</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="drLanguage" value="<%=drModel.getLanguage()%>" />
								</div>
							</div>

							<div class="col-lg-6">
								<div class="form-group" style="color: black;">
									<label class="col-sm-6 control-label" for="card-number">Appointment
										Time:</label>
									<div class="col-sm-6" style="padding-left: 8px">
										<input maxlength="100" type="text" class="form-control"
											name="apptTime" value="<%=drModel.getAppointMentTime()%>" />
									</div>
								</div>
							</div>
						

							<%
								}
							%>
					
							
								<button type="submit" class="btn btn-success pull-right">Update Dr
									Account</button><br>
							
						</form>
						<br> <br>
					</div>
					
					<center>						
						<form action="<%=request.getContextPath() %>/UpdateDrPicture" enctype="multipart/form-data" method="post">
						<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Photo:</label>
								<div class="col-sm-6">
									<input maxlength="100" type="file" class="form-control"
										name="photo"/>
								</div>
							</div>
							
							<button type="submit" class="btn btn-success pull-right">Change Profile Picture</button>
						</form>
					</center>
					
				</div>
			</div>
		</div>
	</div>
<br>
<br>
<br>
	<%@include file="footer.jsp"%>

</body>
</html>