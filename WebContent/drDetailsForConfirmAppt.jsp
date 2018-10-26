<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.stayhealthy.appt.model.DrDetailsModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Book Appointment</title>
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
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

<%@include file="header.jsp"%>
<br>
<br>
<br>
<style>
th {
	font-size: 18pt;
	text-align: left;
	color: black;
	padding-right: 40px;
	padding-bottom: 5px;
}

td {
	font-size: 18pt;
	font-weight: bold;
	color: green;
}
</style>
</head>
<body background="img/pic20.png">
	<div class="container">
		<br>
		<%
			String from = (String) request.getAttribute("from");
		%>
		<center>
			<form
				action="<%=request.getContextPath()%>/BookingAppointmentServlet">

				<%
					DrDetailsModel model = null;
					List<DrDetailsModel> drDetails = (ArrayList<DrDetailsModel>) session.getAttribute("drDetails");
					if (drDetails != null && drDetails.size() > 0)
						model = drDetails.get(0);
				%>



				<div class="media">

					<table style="width: 100%">
						<tr style="width: 100%">
							<td width="60%">
								<div style="width: 100%">

									<table style="padding: 10px">
										<tr>
											<th>Check Up Day</th>
											<td style="color: orange;"><%=model.getAppointMentDay()%></td>
										</tr>
										<tr>
											<th>Check Up Time</th>
											<td><%=model.getAppointMentTime()%></td>
										</tr>
										<tr>
											<th>About Dr</th>
											<td style="color: blue;"><%=model.getDrStatus()%></td>
										</tr>
										<tr>
											<th>Specialization</th>
											<td style="color: orange;"><%=model.getSpecialization()%></td>

										</tr>
										<tr>
											<th>Chember</th>
											<td style="color: #00cc00;"><%=model.getDrChember()%></td>

										</tr>
										<tr>
											<th>Dr Language</th>
											<td style="color: red;"><%=model.getLanguage()%></td>

										</tr>

										<%
											if (from == null) {
										%>
										<tr>
											<th>Book your appointmnt date</th>
											<td><label class="control-label" for="date"> </label> <input
												class="form-control" id="date" name="apptDate"
												placeholder="Choose date for appointment" type="text" /></td>
										</tr>
										<tr>
										
										
										<th>Name of the patient</th>
											<td><label class="control-label" for="pName"> </label> <input
												class="form-control" id="pName" name="patientName"
												placeholder="Enter patient's name" type="text" /></td>
										
											<!-- <th>Name of the patient</th>
											<td><input type="text" style="font-size: 10pt;" size="50" name="patientName"
												placeholder="Enter patient's name"></td>
											 -->	
												
												
										</tr>
										<tr>
											<td colspan="2">
												<div style="padding-top: 40px;">
													<center>
														<button type="submit" class="btn btn-warning">Book
															Appointment</button>
													</center>
												</div>
											</td>

										</tr>
										<%
											}
										%>


									</table>
									<%
										session.setAttribute("drApptDay", model.getAppointMentDay());
										session.setAttribute("drName", model.getDrName());
									%>

								</div>
							</td>
							<br>
							<br>
							<br>
							<td width="40%">
								<div style="width: 100%">

									<center>
										<div class="media-left media-top">
											<img src="PhotoServlet"
												class="media-object" alt="Dr Picture"
												style="width: 250px; border: 2px solid black;">
										</div>
										<br>
										<div class="media-body">
											<h4 class="media-heading" style="color: black;">
												<b><%=model.getDrName()%></b>
											</h4>
										</div>
									</center>
								</div>

							</td>
						</tr>

					</table>


				</div>
				<br>
				<hr>
			</form>
	</div>
	<br>
	<br>

	<script>
		$(document).ready(
				function() {
					var dt = new Date();
					var date_input = $('input[name="apptDate"]');
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					var options = {
						format : 'yyyy/mm/dd',
						container : container,
						todayHighlight : true,
						autoclose : true,
						startDate : dt

					};
					date_input.datepicker(options);
				})
	</script>
	<%@include file="footer.jsp"%>
</body>
</html>