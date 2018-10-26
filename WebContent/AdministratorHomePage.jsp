<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Administrator Page</title>
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

<%@ include file="header.jsp"%>
</head>
<br>
<br>
<br>
<body background="img/pic20.png">
	<br>
	<br>
	<br>
	<br>
	<div class="container">
	<center>	<div class="col-md-2 col-sm-4 col-xs-8">

			<a href="insertDrDetailsPage.jsp"><button type="button"
					class="btn btn-primary">Insert doctor details</button></a>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-8">
			<a href="EditDrDetailsAdminPage.jsp"><button type="button"
					class="btn btn-success">Update doctor details</button></a>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-8">
			<a href="<%=request.getContextPath()%>/ListOfDrServlet"><button
					type="button" class="btn btn-info">View doctor details</button></a>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-8">
			<a href="<%=request.getContextPath()%>/ViewPatientsApptsServlet"><button
					type="button" class="btn btn-warning">View Appointments</button></a>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-8">
			<a href="<%=request.getContextPath()%>/ListOfDrForDeleteServlet"><button
					type="button" class="btn btn-danger">Delete doctor details</button></a>
		</div></center>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>