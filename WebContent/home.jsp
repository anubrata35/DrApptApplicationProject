<%@page import="com.stayhealthy.appt.model.SignUpModel"%>
<%@page import="java.util.List"%>
<%@page import="com.stayhealthy.appt.dao.DAOFactory"%>
<%@page import="com.stayhealthy.appt.dao.LoginDAO"%>
<%@page import="com.stayhealthy.appt.helper.DateHelper"%>

<%@page import="com.stayhealthy.appt.model.AppointmentModel"%>

<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Home Page</title>
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
<br>
<br>
<br>
<br>
<style>
h3 {
	color: rgb(241, 57, 75);
	font-family: Elephant;
	font-size: 250%;
}

.row.content {
	height: 450px
}

th {
	font-size: 12pt;
	text-align: center;
}

@media screen and (max-width: 767px) .row.content {
	height
	:auto
	;
}

}
body {
	background-color: red;
}
</style>
</head>
<body background="img/pic20.png">
	<%
		String userId = (String) session.getAttribute("userId");
		LoginDAO loginDAO = DAOFactory.getLoginDAO();
		List<SignUpModel> userDetailsList = loginDAO.getAccountDetails(userId);
		if (userDetailsList != null)
			for (SignUpModel userDetails : userDetailsList) {
	%>
	<center>
		<h3>
			<b>Hello <%=userDetails.getFirstName()%> <%=userDetails.getLastName()%>
				your appointment details is shown bellow...
			</b>
		</h3>
	</center>
	<br>
	<%
		}
	%>
	<center>
		<h3 style="color: darkgreen; font-weight: bold;">PAITENT
			APPOINTMENT DETAILS</h3>
		<hr>

	</center>
	<form action="<%=request.getContextPath()%>/CancelAppointmentServlet"
		method="post">
		<div class="container" style="width: 100%">
			<%
				ArrayList<AppointmentModel> al = (ArrayList<AppointmentModel>) session.getAttribute("appointmentList");

				if ((al != null) && (al.size() > 0)) {
			%>
			<table class="table table-bordered"
				style="color: black; border: 2px solid black; width: 100%">
				<thead style="color: black;">
					<tr>
						<th>Patient Name</th>
						<th>Patient Number</th>
						<th>Doctor Name</th>
						<th>Appointment booked on</th>
						<th>Appointment schedule date</th>
						<th>Cancel Appointment</th>
					</tr>
				</thead>
				<%
					} else {
				%>
				<center>
					<br>
					<h3
						style="color: black; font-family: monospace; font-weight: bold;">You
						do not have any appointment...</h3>
				</center>
				<%
					}
				%>
				<%
					ArrayList<AppointmentModel> arrayList = (ArrayList<AppointmentModel>) session
							.getAttribute("appointmentList");

					if (arrayList != null)

						for (AppointmentModel model : arrayList) {
				%>
				<center>
					<div class="col-md-12 " style="width: 100%">
						<tbody style="font-weight: bold; text-align: center;">
							<tr class="danger">
								<td style="color: orange;"><%=model.getPatientName()%></td>
								<td>
									<%
										int patientNumber = model.getPatientNumber();
									%><%=patientNumber%></td>
								<td style="color: blue;"><a
									href="./BookApptServlet?from=appt&selectDoctor=<%=model.getDrName()%>">
										<%=model.getDrName()%>

								</a></td>
								<td style="color: orange;"><%=DateHelper.getDateTime12hour(model.getBookAppt())%></td>
								<td style="color: #00cc00;"><%=DateHelper.getDateOnly(model.getFixApptDate())%></td>
								<%
									request.setAttribute("apptScheduledOn", DateHelper.getDateOnly(model.getFixApptDate()));
								%>
								<td style="color: red;"><input type="radio"
									name="cancelAppt" value="<%=patientNumber%>"> Select
									appointment to cancel</input></td>
							</tr>
						</tbody>
					</div>
				</center>
				<%
					}
				%>
			</table>
			<%
				ArrayList<AppointmentModel> arl = (ArrayList<AppointmentModel>) session.getAttribute("appointmentList");

				if ((arl != null) && (arl.size() > 0)) {
			%><br>
			<center>
				<button type="submit" class="btn btn-warning">Cancel
					Appointment</button>
			</center>
			<%
				}
			%>
			<br> <br>
			<hr>
			<br> <br> <br>
			<!-- START THE FEATURETTES -->
			<div class="featurette-row">
				<center>
					<h1 style="color: black;">FEEDBACK</h1>
				</center>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="well"
						style="-webkit-animation-name: slideInLeft; -webkit-animation-duration: 0.75s; -webkit-animation-iteration-count: infinite; -webkit-animation-duration: 10s; animation-name: slideInLeft; animation-duration: 0.100s; animation-iteration-count: infinite; animation-duration: 10s;">
						<p style="color: black;">
							Riya Mandal: <br> Great doctors, really happy with this
							website!!!
						</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="well"
						style="-webkit-animation-name: slideInLeft; -webkit-animation-duration: 0.75s; -webkit-animation-iteration-count: infinite; -webkit-animation-duration: 10s; animation-name: slideInLeft; animation-duration: 0.100s; animation-iteration-count: infinite; animation-duration: 10s;">
						<p style="color: black;">
							Anubrata Giri: <br> it has a great service, and timely
							response!!!
						</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="well"
						style="-webkit-animation-name: slideInLeft; -webkit-animation-duration: 0.75s; -webkit-animation-iteration-count: infinite; -webkit-animation-duration: 10s; animation-name: slideInLeft; animation-duration: 0.100s; animation-iteration-count: infinite; animation-duration: 10s;">
						<p style="color: black;">
							Manorama Das:<br> great website, every detail is present
							here :)
						</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="well"
						style="-webkit-animation-name: slideInLeft; -webkit-animation-duration: 0.75s; -webkit-animation-iteration-count: infinite; -webkit-animation-duration: 10s; animation-name: slideInLeft; animation-duration: 0.100s; animation-iteration-count: infinite; animation-duration: 10s;">
						<p style="color: black;">
							Akanksha Sengupta:<br> awesome experience with great
							service!!
						</p>
					</div>
				</div>


			</div>

			<!-- /END THE FEATURETTES -->
		</div>
	</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>