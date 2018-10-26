<%@page import="com.stayhealthy.appt.model.DrDetailsModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.TreeSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Book Appointment Page</title>
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
<style>
.optionStyle {
	font-size: 10pt;
	color: brown;
	font-weight: bold;
}

.drName {
	font-size: 11pt;
	font-weight: bold;
	color: orange;
}

.drChember {
	font-size: 11pt;
	font-weight: bold;
	color: blue;
}

.drSpe {
	font-size: 11pt;
	font-weight: bold;
	color: green;
}

.drSelect {
	font-size: 11pt;
	font-weight: bold;
	color: tomato;
}
</style>
<br>
<br>
<script>
	function changeOption() {

		document.forms[0].action = "./OnChangeForBookApptServlet";
		document.forms[0].submit();
	}
</script>

</head>
<body background="img/pic20.png">
	<div class="container">

		<div class="row">

			<div class="col-md-12">
				<center
					style="letter-spacing: 2pt; font-weight: bold; font-size: 24pt; color: black;">Find
					and Book appointment with Doctor</center>
				<br> <br> <br>
				<form
					action="<%=request.getContextPath()%>/OnChangeForBookApptServlet">
					<div>
						<center>
							<label for="sel1" id="optTitle"
								style="color: blue; font-size: 14pt;">Select City</label>
						</center>
						<select style="font-size: 12pt; color: brown; font-weight: bold;"
							name="city" id="sel1" class="form-control">
							<option value="0" class="optionStyle" class="optValue"
								disabled="disabled" selected="selected">Select City</option>
							<option value="NewDelhi" class="optionStyle" class="optValue">New
								Delhi</option>
							<option value="Banglore" class="optionStyle" class="optValue">Banglore</option>
							<option value="Kolkata" class="optionStyle" class="optValue">Kolkata</option>
							<option value="Chennai" class="optionStyle" class="optValue">Chennai</option>
						</select>
					</div>
					<br>
					<div>
						<center>
							<label for="sel2" id="optTitle"
								style="color: orange; font-size: 14pt; font-weight: bold;">Select
								Hospital Name</label>
						</center>
						<select name="hospital" id="sel2" class="form-control"
							style="font-size: 12pt; color: brown; font-weight: bold;">
							<option value="0" class="optionStyle" class="optValue"
								disabled="disabled" selected="selected" class="optionStyle">Select
								Hospital</option>
							<option value="Stay Healthy Hospital Howrah" class="optionStyle"
								class="optValue">Stay Healthy Hospital Howrah</option>
							<option value="Stay Healthy Hospital Bangur" class="optionStyle"
								class="optValue">Stay Healthy Hospital Bangur</option>
							<option value="Stay Healthy Hospital Delhi" class="optionStyle"
								class="optValue">Stay Healthy Hospital Delhi</option>
							<option value="Stay Healthy Hospital Chennai" class="optionStyle"
								class="optValue">Stay Healthy Hospital Chennai</option>
							<option value="Stay Healthy Hospital Banglore"
								class="optionStyle" class="optValue">Stay Healthy
								Hospital Banglore</option>
						</select>
					</div>
					<br>

					<center>
						<button type="submit" onclick="changeOption()"
							class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
					</center>

				</form>
				<br>
				<hr>
				<center>
					<form action=" <%=request.getContextPath()%>/BookApptServlet ">
						<table class="table table-striped" style="padding: 8px">
							<thead style="color: darkblue; font-size: 14pt">
								<tr>
									<th>Dr Name</th>
									<th>Specialist</th>
									<th>Dr Chember</th>
									<th>Select Doctor</th>
								</tr>
								<%
									ArrayList<DrDetailsModel> getArrayList = (ArrayList<DrDetailsModel>) session.getAttribute("DrDetailsList");
									if (getArrayList != null)
										for (DrDetailsModel model : getArrayList) {
								%>
							</thead>
							<tbody style="color: black;">
								<tr>
									<td class="drName">
										<%
											String drName = model.getDrName();
													if (!drName.contains("Dr.")) {
										%>Dr. <%=drName%> <%
 	} else {
 %> <%=drName%> <%
 	}
 %>
									</td>
									<td class="drSpe"><%=model.getSpecialization()%></td>
									<td class="drChember"><%=model.getDrChember()%></td>
									<td class="drSelect"><b><input type="radio"
											name="selectDoctor" value="<%=drName%>"> Select this
											Dr for Appointment</b></input></td>
								</tr>
							</tbody>
							<%
								}
							%>
						</table>

						<center>
							<button type="submit" class="btn btn-info">
								<span class="glyphicon glyphicon-arrow-right"></span> NEXT
							</button>
						</center>
					</form>
				</center>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>