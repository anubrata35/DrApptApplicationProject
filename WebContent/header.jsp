<!DOCTYPE HTML>
<%
	String message = (String) request.getAttribute("message");

	if (message == null) {
		message = "";
	}

	/* String msg = ""; */
	String userLoggedIn = (String) session.getAttribute("userId");
	String adminLoggedIn = (String) session.getAttribute("admin");

	/* if (userLoggedIn != null) {
		msg = "Welcome " + userLoggedIn + " you are logged in...";
	} else if (adminLoggedIn != null) {
		msg = "Welcome " + adminLoggedIn + " you are logged in...";
	} else {
	
		msg = "Welcome user! We are always here to serve our better services...";
	} */
%>
<html>
<head>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<div class="col-md-4 col-sm-6 col-xs-12">
					<a class="logo-img" href="index.jsp"> <img src="img/pro22.png"
						alt="stayhealthylogo" />
					</a>
				</div>
				<div class="col-md-8 col-sm-6 col-xs-12">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<div class="col-md-12">
							<ul class="nav navbar-nav">
								<li><a href="index.jsp"> <span
										class="glyphicon glyphicon-home"></span> HOME
								</a></li>
								<li><a href="aboutUs.jsp"> <span
										class="glyphicon glyphicon-question-sign"></span> ABOUT US
								</a></li>

								<%
									if (userLoggedIn != null) {
								%>

								<li><a href="home.jsp"> <span
										class="glyphicon glyphicon-list-alt"></span> APPOINTMENTS
								</a></li>
								<li><a href="BookDrAppointment.jsp"> <span
										class="glyphicon glyphicon-apple"></span> BOOK APPOINTMENTS
								</a></li>
								<li><a href="./AccountDetailsServlet"> <span
										class="glyphicon glyphicon-pencil"></span> ACCOUNTS
								</a></li>

								<%
									} else if (adminLoggedIn != null) {
								%>
								<li><a href="AdministratorHomePage.jsp"> <span
										class="glyphicon glyphicon-cog"></span> ADMINISTRATOR HOME
								</a></li>
								<%
									} else {
								%>

								<li><a href="#" data-toggle="modal" data-target="#myModal">
										<span class="glyphicon glyphicon-log-in"></span> LOGIN
								</a></li>

								<%
									}
								%>

								<li><a href="contactUsPage.jsp"> <span
										class="glyphicon glyphicon-earphone"></span> CONTACT US
								</a></li>
								<ul class="nav navbar-nav navbar-right pull-right">
									<%
										if ((userLoggedIn == null) && (adminLoggedIn == null)) {
									%>
									<li><a href="SignUpPageJsp.jsp"> <span
											class="glyphicon glyphicon-briefcase"></span> SIGN UP
									</a></li>
									<%
										}
									%>

									<%
 	if ((adminLoggedIn != null)||(userLoggedIn != null)) {
 %>
									<li><a href="./SignOutServlet"> <span
											class="glyphicon glyphicon-log-out"></span> LOGOUT
									</a></li>

									<%
										}
									%>
									<br>
									
									
									<%
										if (userLoggedIn != null) {
									%>

									<li><span>&nbsp;&nbsp;&nbsp; Welcome ! &nbsp;&nbsp; <a
											style="font-weight: bold;" href="./AccountDetailsServlet">
											<%=session.getAttribute("userId")%>
										</a>
									</span></li>

									<%
									}else if (adminLoggedIn != null) {
									%>

									<li>&nbsp;&nbsp;&nbsp; Welcome ! &nbsp;&nbsp;<span style="font-weight: bold;">
											<%=session.getAttribute("admin")%>
									</span> <%
 	}
 %> 
									
									
									
									
									<br>
								</ul>
							</ul>
						</div>
						<span style="color: red; font-weight: bold;" class="pull-right"><%=message%></span>
					</div>
				</div>
			</div>
		</div>
		<style>
.modal.modal-wide {
	overflow: hidden;
}

.modal.modal-wide .modal-dialog {
	width: 94%;
}

.modal-wide .modal-body {
	overflow-y: auto;
}

@
-webkit-keyframes ezCustTrans { 0% {
	-webkit-transform-style: preserve-3d;
	-moz-transform-style: preserve-3d;
	transform-style: preserve-3d;
	-webkit-transform: perspective(90%) rotateY(-65deg) rotateX(-45deg)
		translateZ(-200px);
	-moz-transform: perspective(90%) rotateY(-65deg) rotateX(-45deg)
		translateZ(-200px);
	-ms-transform: perspective(90%) rotateY(-65deg) rotateX(-45deg)
		translateZ(-200px);
	transform: perspective(90%) rotateY(-65deg) rotateX(-45deg)
		translateZ(-200px);
	opacity: 0;
}

68%
{
-webkit-transform






















:











  











rotateY






















(10
deg




















)
rotateX






















(10
deg




















)
translateZ






















(20
px




















);
-moz-transform






















:











  











rotateY






















(10
deg




















)
rotateX






















(10
deg




















)
translateZ






















(20
px




















);
-ms-transform






















:











  











rotateY






















(10
deg




















)
rotateX






















(10
deg




















)
translateZ






















(20
px




















);
transform






















:











  











rotateY






















(10
deg




















)
rotateX






















(10
deg




















)
translateZ






















(20
px




















);
opacity






















:











 











0
.8






















;
}
100%
{
-webkit-transform






















:











  











rotateY






















(0
deg




















)
rotateX






















(0
deg




















)
translateZ






















(0
px




















);
-moz-transform






















:











  











rotateY






















(0
deg




















)
rotateX






















(0
deg




















)
translateZ






















(0
px




















);
-ms-transform






















:











  











rotateY






















(0
deg




















)
rotateX






















(0
deg




















)
translateZ






















(0
px




















);
transform






















:











  











rotateY






















(0
deg




















)
rotateX






















(0
deg




















)
translateZ






















(0
px




















);
opacity






















:











 











1;
}
}
@
keyframes ezCustTrans { 0% {
	-webkit-transform-style: preserve-3d;
	-moz-transform-style: preserve-3d;
	transform-style: preserve-3d;
	-webkit-transform: perspective(90%) rotateY(-65deg) rotateX(-45deg)
		translateZ(-200px);
	-moz-transform: perspective(90%) rotateY(-65deg) rotateX(-45deg)
		translateZ(-200px);
	-ms-transform: perspective(90%) rotateY(-65deg) rotateX(-45deg)
		translateZ(-200px);
	transform: perspective(90%) rotateY(-65deg) rotateX(-45deg)
		translateZ(-200px);
	opacity: 0;
}

68%
{
-webkit-transform






















:











  











rotateY






















(10
deg




















)
rotateX






















(10
deg




















)
translateZ






















(20
px




















);
-moz-transform






















:











  











rotateY






















(10
deg




















)
rotateX






















(10
deg




















)
translateZ






















(20
px




















);
-ms-transform






















:











  











rotateY






















(10
deg




















)
rotateX






















(10
deg




















)
translateZ






















(20
px




















);
transform






















:











  











rotateY






















(10
deg




















)
rotateX






















(10
deg




















)
translateZ






















(20
px




















);
opacity






















:











 











0
.8






















;
}
100%
{
-webkit-transform






















:











 











rotateY






















(0
deg




















)
rotateX






















(0
deg




















)
translateZ






















(0
px




















);
-moz-transform






















:











  











rotateY






















(0
deg




















)
rotateX






















(0
deg




















)
translateZ






















(0
px




















);
-ms-transform






















:











  











rotateY






















(0
deg




















)
rotateX






















(0
deg




















)
translateZ






















(0
px




















);
transform






















:











  











rotateY






















(0
deg




















)
rotateX






















(0
deg




















)
translateZ






















(0
px




















);
opacity






















:











 











1;
}
}
.ezCustTrans {
	-webkit-animation-duration: 0.75s;
	animation-duration: 0.75s;
	-webkit-animation-fill-mode: both;
	animation-fill-mode: both;
	-webkit-animation-name: bounceIn;
	animation-name: bounceIn;
}
</style>

		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-dialog ezCustTrans">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<center>
								<h4 class="modal-title">
									<b style="font-size: 18px;">Log In</b>
								</h4>
							</center>
						</div>
						<div class="modal-body">

							<form action="<%=request.getContextPath()%>/LogInPageServlet"
								method="post">
								<ul>
									<center style="font-weight: bold;">
										<input type="hidden" name="role" value="role">&nbsp;&nbsp;&nbsp; User
										ID: &nbsp;<input style="font-weight: normal; color: gray;" type="text"
											name="userId" placeholder="Enter valid id" maxlength="100" /><br>
										<br> Password : <input style="font-weight: normal; color: gray;" type="password"
											placeholder="Enter password" name="password"
											maxlength="100" /><br>
									</center>
									<br>

								</ul>
								<center>
									<input style="font-weight: bold;" type="submit" value="Login" class="btn btn-success xl" />
								</center>
								<br>
							</form>
							<center>
								<p>
									<a href="SignUpPageJsp.jsp">New to STAY HEALTHY ?</a>
								</p>
							</center>

							<p>Sign in with social account</p>
							<div class="row">
								<div class="col-sm-1">
									<center>
										<a href="http://www.facebook.com"><img
											src="img/facebook1.png" alt="Flower" class="img-responsive"
											width="150" height="150"></a>
								</div>
								<div class="col-sm-1">
									<a href="https://plus.google.com"><img
										src="img/Google1.png" alt="Flower" class="img-responsive"
										width="250" height="250"></a>
									</center>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button"  class="btn btn-danger xl" 
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		</ul>
		</div>
	</nav>
	<%-- 
	<br>
	<marquee style="font-weight: bold; letter-spacing: 1pt;"
		class="pull-right">
		<%=msg%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</marquee> --%>
</body>
</html>
