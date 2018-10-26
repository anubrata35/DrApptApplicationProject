<%@page import="com.stayhealthy.appt.model.SignUpModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details Page</title>
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
	<%
		ArrayList<SignUpModel> getAccountDetails = (ArrayList<SignUpModel>) session.getAttribute("accountDetails");
		if (getAccountDetails.size() > 0) {
			SignUpModel userAccountDetails = getAccountDetails.get(0);
	%>

	<form action="<%=request.getContextPath()%>/UpdateServlet"
		method="post">

		<div class="container">

			<div class="row setup-content" id="ProfileSetup-step">
				<div class="col-xs-12">
					<div class="col-md-12">
						<br />
						<div class="form-horizontal">

							<fieldset>
								<legend style="color: blue">
									<b>Update Your Profile Information</b>
								</legend>
								<br />
								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">First
										Name:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="text" class="form-control"
											name="firstname"
											value="<%=userAccountDetails.getFirstName()%>" />
									</div>
								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">
										Last Name:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="text" class="form-control"
											name="lastname" value="<%=userAccountDetails.getLastName()%>" />
									</div>

								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">Gender:</label>
									<%
										String gender = userAccountDetails.getGender();
											if (gender.equalsIgnoreCase("male")) {
									%>
									<div class="col-sm-9">
										<label for="male">Male</label> <input type="radio"
											name="gender" id="male" value="male" checked="checked" /> <label
											for="female">Female</label> <input type="radio" name="gender"
											id="female" value="female" />
									</div>
									<%
										} else {
									%>
									<div class="col-sm-9">
										<label for="male">Male</label> <input type="radio"
											name="gender" id="male" value="male" /> <label for="female">Female</label>
										<input type="radio" name="gender" id="female" value="female"
											checked="checked" />
									</div>
									<%
										}
									%>
								</div>
								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">
										Date Of Birth:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="text" class="form-control"
											name="bday" value="<%=userAccountDetails.getBirtDate()%>" />
									</div>
								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">
										Email[Optional]:</label>
									<div class="col-sm-9">
										<%
											String emailId = userAccountDetails.getEmail();
												if (emailId != null) {
										%>
										<input maxlength="100" type="email" class="form-control"
											name="email" value="<%=emailId%>" />
										<%
											} else {
										%>
										<input maxlength="100" type="email" class="form-control"
											name="email" value="" />
										<%
											}
										%>
									</div>
								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-number">Phone
										Number:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="text" class="form-control"
											name="phonenumber"
											value="<%=userAccountDetails.getPhoneNumber()%>" />
									</div>
								</div>
								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-number">Address:</label>
									<div class="col-sm-9">
										<textarea maxlength="100" type="text" class="form-control"
											name="address"><%=userAccountDetails.getAddress()%>
										</textarea>

									</div>
								</div>

								

								<div class="col-lg-6">
									<div class="form-group" style="color: black;">
										<label class="col-sm-6 control-label" for="card-number">Password:</label>
										<div class="col-sm-6" style="padding-left: 8px">
											<input maxlength="100" type="password" class="form-control"
												name="password"
												value="<%=userAccountDetails.getPassword()%>" />
										</div>
									</div>
								</div>

								<div class="col-lg-6">
									<div class="form-group" style="color: black;">
										<label class="col-sm-6 control-label" for="card-number">Confirm
											Password:</label>
										<div class="col-sm-6" style="padding-left: 8px">
											<input maxlength="100" type="password" class="form-control"
												name="confirmpassword"
												value="<%=userAccountDetails.getPassword()%>" />
										</div>
									</div>
								</div>
								
								
								
								<div class="col-lg-6">
									<div class="form-group" style="color: black;">
										<label class="col-sm-6 control-label" for="card-number">Location: </label>
										<%
											String location = userAccountDetails.getLocation();
												if (location.equalsIgnoreCase("newDelhi")) {
										%>
										<div class="col-sm-6" style="padding: 0px">
											<select class="form-control" name="location">
												<option disabled="disabled">Select Location</option>
												<option value="newDelhi" selected="selected">New
													Delhi</option>
												<option value="banglore">Banglore</option>
												<option value="kolkata">Kolkata</option>
												<option value="chennai">Chennai</option>
											</select>
										</div>
										<%
											} else if (location.equalsIgnoreCase("banglore")) {
										%>
										<div class="col-sm-6" style="padding: 0px">
											<select class="form-control" name="location">
												<option disabled="disabled">Select Location</option>
												<option value="newDelhi">New Delhi</option>
												<option value="banglore" selected="selected">Banglore</option>
												<option value="kolkata">Kolkata</option>
												<option value="chennai">Chennai</option>
											</select>
										</div>
										<%
											} else if (location.equalsIgnoreCase("kolkata")) {
										%>
										<div class="col-sm-6" style="padding: 0px">
											<select class="form-control" name="location">
												<option disabled="disabled">Select Location</option>
												<option value="newDelhi">New Delhi</option>
												<option value="banglore">Banglore</option>
												<option value="kolkata" selected="selected">Kolkata</option>
												<option value="chennai">Chennai</option>
											</select>
										</div>
										<%
											} else {
										%>
										<div class="col-sm-6" style="padding: 0px">
											<select class="form-control" name="location">
												<option disabled="disabled">Select Location</option>
												<option value="newDelhi">New Delhi</option>
												<option value="banglore">Banglore</option>
												<option value="kolkata">Kolkata</option>
												<option value="chennai" selected="selected">Chennai</option>
											</select>
										</div>
										<%
											}
										%>
									</div>
								</div>

							</fieldset>

							<br>
						</div>
						<center><button type="submit" class="btn btn-danger">Save
							and continue</button></center>
					</div>
				</div>
			</div>
		</div>

	</form>
	<%
		}
	%>
	<br>

	<center><form action="<%=request.getContextPath()%>/DeleteAccountServlet">
		<button type="submit" class="btn btn-danger ">Delete
			Account Permanently</button></center>
	</form>
<br>
	<%@include file="footer.jsp"%>
</body>
</html>