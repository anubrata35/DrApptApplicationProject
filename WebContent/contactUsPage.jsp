<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--Favicons -->
<link rel="shortcut icon" href="images/favico.ico">
<title>Contact Us Page</title>
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
	<!-- Contact Start -->
	<section class="contact" id="contact">
		<div class="container">
			<div class="row">

				<div class="col-sm-12 animated zoomIn wow" data-wow-delay=".5s">
					<div class="header-title">
						<h1 style="color: black;">Contact Us</h1>
						<hr>
						<p style="color: black;">You can contact us in our number
							given below, you can also mail us, any problem we are ready to
							serve.</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6 col-sm-6 col-lg-6">
					<div class="contact-inform">
						<h2 style="color: black;">Get in touch</h2>
					</div>
					<div class="contact-detial" style="color: black;">
						<div class="clearfix ci-items fadeIn animated wow"
							data-wow-delay=".1s">
							<span class="ci-icons"><i class="zmdi zmdi-home"></i></span>
							<address>Azimgunj building, camac street, kolkata</address>
						</div>

						<div class="clearfix ci-items fadeIn animated wow"
							data-wow-delay=".2s" style="color: black;">
							<span class="ci-icons"><i class="zmdi zmdi-email"></i></span>
							<address>stayhealthyofficial@gmail.com</address>
						</div>

						<div class="clearfix ci-items fadeIn animated wow"
							data-wow-delay=".3s" style="color: black;">
							<span class="ci-icons"><i class="zmdi zmdi-phone"></i></span>
							<address>+123 654 657 1110</address>
						</div>

						<div class="clearfix ci-items fadeIn animated wow"
							data-wow-delay=".4s" style="color: black;">
							<span class="ci-icons"><i class="zmdi zmdi-globe"></i></span>
							<address>
								<a href="index.jsp" target="_stayhealthy">www.stayhealthy.com</a>
							</address>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-sm-6 col-lg-6">
					<div class="section-form">
						<form
							action="<%=request.getContextPath()%>/CustomarFeedbackServlet"
							method="post">
							<div class="row">
								<div class="col-sm-12 col-md-6 input-field fadeIn animated wow"
									data-wow-delay=".1s">
									<div class="input-field">
										<input class="form-control input-box" id="name2"
											name="clientName" type="text"
											placeholder="Please enter your name"> <label
											for="name2" class="input-label" style="color: black;">Name</label>
									</div>
								</div>

								<div class="col-sm-12 col-md-6 input-field fadeIn animated wow"
									data-wow-delay=".2s">
									<div class="input-field">
										<input class="form-control input-box" id="email"
											name="emailId" type="email"
											placeholder="Please enter your valid email..."> <label
											for="email" class="input-label" style="color: black;">Email</label>
									</div>
								</div>

								
								<div class="col-sm-12 input-field fadeIn animated wow"
									data-wow-delay=".3s">
									<div class="input-field">
										<input class="form-control input-box" id="subject" type="text"
											name="mailSubject" placeholder="Please enter subject">

										<label for="subject" class="input-label" style="color: black;">Subject</label>
									</div>
								</div>

								<div class="col-sm-12 input-field fadeIn animated wow"
									data-wow-delay=".3s">
									<div class="input-field">
										<input class="form-control input-box" id="phoneNumber"
											type="text" name="mobileNumber"
											placeholder="Please enter your valid mobile number">

										<label for="phoneNumber" class="input-label"
											style="color: black;">Phone Number</label>
									</div>
								</div>

								<div class="col-sm-12 input-field fadeIn animated wow"
									data-wow-delay=".4s">
									<div class="input-field textarea-input">
										<textarea class="form-control materialize-textarea"
											id="mailBody" name="mailBody"
											placeholder="Please write your feedback here"></textarea>
										<label for="mailBody" class="input-label"
											style="color: black;">Message</label>
									</div>

								</div>

								<div class="col-sm-12 input-field-submit">
									<div
										class="input-field-send submit-wrap clearfix fadeIn animated wow"
										data-wow-delay=".5s">

										<button type="submit"
											class="left waves-effect waves-light btn-flat brand-text submit-btn"
											style="color: black;">Send Feedback</button>
									</div>
								</div>

							</div>
						</form>
					</div>
				</div>

			</div>
			<!--End row -->

		</div>
	</section>
	<hr>
	<div>
		<h3>Get our location</h3>
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3684.9385880990208!2d88.34974381453566!3d22.543973135197565!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a0277176cbf90d3%3A0x5466052e0485d78!2sAzimganz+House%2C+7%2C+Camac+St%2C+Elgin%2C+Kolkata%2C+West+Bengal+700017!5e0!3m2!1sen!2sin!4v1500360524587"
			width="100%" height="350" frameborder="2px" style="border: 0"
			allowfullscreen></iframe>
	</div>
	<!-- /Emd Contact Start -->
	<br>
	<br>
	<br>
	<%@include file="footer.jsp"%>
</body>
</html>
