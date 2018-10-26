<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert Dr Data Page</title>
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

						<center>
							<b style="font-size: 18pt; color: darkblue;">INSERT DOCTOR
								DETAILS</b>
						</center>
						<br> <br>
						<form action="<%=request.getContextPath()%>/xyz"
							enctype="multipart/form-data" method="post">
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Doctor
									Name:</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="drName" placeholder="Enter Doctor Name" />
								</div>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Appointment
									Day:</label>
								<div class="col-sm-5">
									<label for="sunDay">Sunday</label> <input type="checkbox"
										name="apptDay" id="sunDay" value="Sunday" data-inline="true" />
									<label for="monDay">Monday</label> <input type="checkbox"
										name="apptDay" id="monDay" value="Monday" data-inline="true" />
									<label for="tuesDay">Tuesday</label> <input type="checkbox"
										name="apptDay" id="tuesDay" value="Tuesday" data-inline="true" />
									<label for="wednesDay">Wednesday</label> <input type="checkbox"
										name="apptDay" id="wednesDay" value="Wednesday"
										data-inline="true" /> <label for="thursDay">Thursday</label>
									<input type="checkbox" name="apptDay" id="thursDay"
										value="Thursday" data-inline="true" /> <label for="friDay">Friday</label>
									<input type="checkbox" name="apptDay" id="friDay"
										value="Friday" data-inline="true" /> <label for="saturDay">Saturday</label>
									<input type="checkbox" name="apptDay" id="saturDay"
										value="Saturday" data-inline="true" />
								</div>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Doctor
									Status:</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="drStatus" placeholder="enter dr status(D.Chem/D.B.A)" />
								</div>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Specialization:
								</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="drSpecialization" placeholder="enter dr specialization" />
								</div>
							</div>

							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Location:</label>
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
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Hospital
									Name: </label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="hospitalName" placeholder="enter name of the hospital" />
								</div>
							</div>
							<div class="form-group" style="color: black;">
								<label class="col-sm-3 control-label" for="card-holder-name">Doctor
									Language:</label>
								<div class="col-sm-9">
									<input maxlength="100" type="text" class="form-control"
										name="drLanguage" placeholder="enter dr language" />
								</div>
							</div>

							<div class="col-lg-6">
								<div class="form-group" style="color: black;">
									<label class="col-sm-6 control-label" for="card-number">Appointment
										Time:</label>
									<div class="col-sm-6" style="padding-left: 8px">
										<input maxlength="100" type="text" class="form-control"
											name="apptTime" placeholder="enter time between(4p.m - 6p.m)" />
									</div>
								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">Photo:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="file" class="form-control"
											name="photo" />
									</div>
								</div>
							</div>
							<br>
							<center>
								<button type="submit" class="btn btn-success">Submit</button>
							</center>

						</form>
						<br> <br>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>