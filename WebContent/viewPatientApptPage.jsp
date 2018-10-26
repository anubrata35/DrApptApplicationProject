
<%@page import="com.sun.deploy.uitoolkit.impl.fx.ui.FXDefaultPreloader"%>
<%@page import="com.stayhealthy.appt.helper.DateHelper"%>
<%@page import="org.hibernate.type.descriptor.java.DataHelper"%>
<%@page import="com.stayhealthy.appt.model.AppointmentModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.stayhealthy.appt.model.DrDetailsModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View appointments</title>
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
	<br>
	<br>
	<div class="container">

		<div class="row setup-content" id="ProfileSetup-step">
			<center>
					<h3 style="color: black; font-weight: bold;">Patient Appointment List</h3><br><br>
				<form
					action="<%=request.getContextPath()%>/CancelApptForAdminServlet">
					<table border="2px solid black"
						style="color: darkblue; font-weight: bold; font-size: 13pt; padding: 8pt">
						<tr style="color: red; background-color: lightgrey;">
							<th>Appointment Fixed on</th>
							<th>Dr Name</th>
							<th>Patient Name</th>
							<th>Patient Number</th>
							<th>Patient's User Id</th>
							<th>Booked Appointment on</th>
							<th>Select Appointment to Delete</th>
						</tr>
						<%
							ArrayList<AppointmentModel> arrayList = (ArrayList<AppointmentModel>) session
									.getAttribute("patientsApptList");
							if (arrayList != null)
								for (AppointmentModel viewPatientApptList : arrayList) {
						%>
						<tr style="color: black; padding: 6px;">
							<td><%=DateHelper.getDateOnly(viewPatientApptList.getFixApptDate())%></td>
							<td><%=viewPatientApptList.getDrName()%></td>
							<td><%=viewPatientApptList.getPatientName()%></td>
							<td>
								<%
									int patientNumber = viewPatientApptList.getPatientNumber();
								%><%=patientNumber%>
							</td>
							<td><%=viewPatientApptList.getUserID()%></td>
							<td><%=DateHelper.getDateTime12hour(viewPatientApptList.getBookAppt())%></td>
							<td><input type="radio" name="selectedAppt"
								value="<%=patientNumber%>" />Delete this appoint</td>
						</tr>
						<%
							}
						%>
					</table>
					<br><br><input type="submit" value="Delete Selected Appointment"
						class="btn btn-danger" />
				</form>
			</center>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>