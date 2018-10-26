<%@page import="java.util.ArrayList"%>
<%@page import="com.stayhealthy.appt.model.DrDetailsModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>List of Dr. Page</title>
<meta charset="utf-8">
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
	<div data-role="page">
		<div data-role="main" class="ui-content">
			<br> <br>
			<center>
				<b style="font-size: 16pt">If you want to update any Dr please
					go to update button in the <a href="AdministratorHomePage.jsp">Administrator
						Home</a> Page...
				</b><br> <br><br>
			</center>
			<center>
				<table border="2px solid black" 
					style="color: darkblue; font-weight: bold; font-size: 12pt; padding:2px;">
					<tr style="color: red; background-color: lightgrey; font-size: 13pt; padding:2px;">
						<th>Dr Id</th>
						<th>Dr Name</th>
						<th>Appointment Day</th>
						<th>Appointment Time</th>
						<th>Dr Status</th>
						<th>Specialization</th>
						<th>Dr Location</th>
						<th>Chember at Hospital</th>
						<th>Language</th>
					</tr>
					<%
						ArrayList<DrDetailsModel> arrayList = (ArrayList<DrDetailsModel>) request.getAttribute("drList");
						if (arrayList != null)
							for (DrDetailsModel viewDrList : arrayList) {
					%>
					<tr>
						<td><%=viewDrList.getpId()%></td>
						<td>
							<%
								String drName = viewDrList.getDrName();
							%> <%
 	if (drName.startsWith("Dr.")) {
 %><%=drName%> <%
 	} else {
 %>Dr. <%=drName%> <%
 	}
 %>
						</td>
						<td><%=viewDrList.getAppointMentDay()%></td>
						<td><%=viewDrList.getAppointMentTime()%></td>
						<td><%=viewDrList.getDrStatus()%></td>
						<td><%=viewDrList.getSpecialization()%></td>
						<td><%=viewDrList.getDrChember()%></td>
						<td><%=viewDrList.getHospitalName()%></td>
						<td><%=viewDrList.getLanguage()%></td>
					</tr>
					<%
						}
					%>
				</table><br><br>
			</center>
		</div>
	</div>
	<br>
	<br>

	<%@include file="footer.jsp"%>
</body>
</html>
