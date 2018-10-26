<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Signup Page</title>
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
	<form action="<%=request.getContextPath()%>/SighUpServlet"
		method="post">

		<div class="container">

			<div class="row setup-content" id="ProfileSetup-step">
				<div class="col-xs-12">
					<div class="col-md-12">
					<br><br>
						<div class="form-horizontal">

							<fieldset>
								<legend style="color: blue">
									<b>Enter Your Profile Information</b>
								</legend><hr>
								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">First
										Name:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="text" class="form-control"
											name="firstname" placeholder="Please enter your first name" />
									</div>
								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">
										Last Name:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="text" class="form-control"
											name="lastname" placeholder="Please enter your last name" />
									</div>

								</div>
								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">
										User ID:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="text" class="form-control"
											name="userid" placeholder="Please make your user id" />
									</div>
								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">Gender:</label>
									<div class="col-sm-9">
										<label for="male">Male</label> <input type="radio"
											name="gender" id="male" value="male" /> <label for="female">Female</label>
										<input type="radio" name="gender" id="female" value="female" />
									</div>
								</div>
								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">
										Date Of Birth:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="date" class="form-control"
											name="bday" placeholder="Name" />
									</div>
								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-holder-name">
										Email[Optional]:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="email" class="form-control"
											name="email" placeholder="Please enter your valid email" />
									</div>
								</div>

								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-number">Phone
										Number:</label>
									<div class="col-sm-9">
										<input maxlength="100" type="text" class="form-control"
											name="phonenumber"
											placeholder="Please enter your mobile number" />
									</div>
								</div>
								<div class="form-group" style="color: black;">
									<label class="col-sm-3 control-label" for="card-number">Address:</label>
									<div class="col-sm-9">
										<textarea maxlength="100" type="text" class="form-control"
											name="address" placeholder="Enter Address"> 
										</textarea>

									</div>
								</div>

								
								<div class="col-lg-6">
									<div class="form-group" style="color: black;">
										<label class="col-sm-6 control-label" for="card-number">Password:</label>
										<div class="col-sm-6" style="padding-left: 8px">
											<input maxlength="100" type="password" class="form-control"
												name="password" placeholder="Please enter password" />
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
												placeholder="Please re-enter password" />
										</div>
									</div>
								</div>
						
						<div class="col-lg-6">
									<div class="form-group" style="color: black;">
										<label class="col-sm-6 control-label" for="card-number">Location:</label>
										<div class="col-sm-6" style="padding: 0px">
											<select class="form-control" name="location">
												<option value="0">Select Location</option>
												<option value="newDelhi">New Delhi</option>
												<option value="banglore">Banglore</option>
												<option value="kolkata">Kolkata</option>
												<option value="chennai">Chennai</option>
											</select>
										</div>
									</div>
								</div>
								<br>
						
							</fieldset>

							<center><fieldset data-role="controlgroup" data-inline="true" class="pull-left">
								<label for="agree" style="color: black;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;I agree all terms and conditions</label> <input
									type="checkbox" name="checkbox" id="agree"
									value="agree" />
							</fieldset></center>
							<br>
						</div>
						<button type="submit" class="btn btn-danger pull-right">Save
							and continue</button>
					</div>
				</div>
			</div>
		</div>

	</form>
	<br>
	<br>
	<br>
	<%@include file="footer.jsp"%>
</body>
</html>