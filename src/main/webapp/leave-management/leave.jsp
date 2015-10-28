<!DOCTYPE html>	
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<script src="/jquery/jquery-1.11.3.js"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/dark-theme.css" />
<link rel="stylesheet" href="/css/form-elements.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seven Seven GSI | Leave Management</title>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top inverse-dark">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../index.html"><img src="../img/77logo-black.png" class="img-responsive" width="120px"/></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="../index.html">Home</a></li>
					<li><a href="../applicant-form/applicant.jsp">Applicant Form</a></li>
					<li><a href="../leave-management/leave.jsp">Leave Management</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="page-start container-fluid">
		<div class="row">
			<!-- 			<div class="col-sm-3 col-md-2 sidebar"> -->
			<!-- 				<ul class="nav nav-sidebar"> -->
			<!-- 					<li><a href="#">Primary Information</a></li> -->
			<!-- 					<li><a href="#otherInformation">Other Information</a></li> -->
			<!-- 					<li><a href="#prevEmployment">Current/Previous Employment -->
			<!-- 							Information</a></li> -->
			<!-- 					<li><a href="#appInformation">Application Information</a></li> -->
			<!-- 				</ul> -->
			<!-- 			</div> -->
			<!-- 			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
			<div class="container-fluid">
				<form class="form-horizontal" action="/leave-management/getLeaveCredits" method="post">
					<!-- -----------------------------FIRST SECTION--------------------------- -->
					<div class="form-group title" id="primaryInformation">
						<h2>Leave Management</h2>
					</div>
					<div class="well welldark-sm">
						<strong><span class="glyphicon glyphicon-asterisk"></span>Required
							Field</strong>
					</div>
					<div class="form-group">
						<label for="firstName"
							class="col-sm-2 control-label required-label">ID Number</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="firstName" name="idNumber" type="text" class="form-control"
									placeholder="ID Number" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="custom">
							<button type="reset" class="btncustom">Clear</button>
							<button type="submit" class="btncustom">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>
