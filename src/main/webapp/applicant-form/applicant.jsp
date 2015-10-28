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
<script src="/js/bootstrap.min.js"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/dark-theme.css" />
<link rel="stylesheet" href="/css/form-elements.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seven Seven GSI | Applicant Form</title>

<script>
</script>
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
				<form class="form-horizontal" action="/applicant-form/insertApplicant" method="post" enctype="multipart/form-data">
					<!-- -----------------------------FIRST SECTION--------------------------- -->
					<div class="form-group title" id="primaryInformation">
						<h2>Primary Information</h2>
					</div>
					<div class="well welldark-sm">
						<strong>
							<span class="glyphicon glyphicon-asterisk"></span>
							Required Field
						</strong>
					</div>
					<div class="form-group">
						<label for="firstName"
							class="col-sm-2 control-label required-label">First Name</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="firstName" name="firstName" type="text" class="form-control"
									placeholder="First Name" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="lastName"
							class="col-sm-2 control-label required-label">Last Name</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="lastName" name="lastName" type="text" class="form-control"
									placeholder="Last Name" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="middleName" class="col-sm-2 control-label">Middle
							Name</label>
						<div class="col-sm-10">
							<input id="middleName" name="middleName" type="text" class="form-control"
								placeholder="Middle Name">
						</div>
					</div>
					<div class="form-group">
						<label for="birthDate"
							class="col-sm-2 control-label required-label">Date of
							Birth</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="birthDate" name="birthdate" placeholder="Date of Birth"
									class="form-control" type="text" onfocus="(this.type='date')"
									onblur="(this.type='text')" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="civilStatus" class="col-sm-2 control-label">Civil
							Status</label>
						<div class="col-sm-10">
							<select id="civilStatus" name="civilStatus" class="form-control">
								<option disabled selected>Civil Status</option>
								<option value="single">Single</option>
								<option value="married">Married</option>
								<option value="widow/widower">Widow/Widower</option>
								<option value="separated">Separated</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="gender" class="col-sm-2 control-label">Gender</label>
						<div class="col-sm-10">
							<select id="gender" name="gender" class="form-control">
								<option disabled selected>Gender</option>
								<option value="male">Male</option>
								<option value="female">Female</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="presentAddress"
							class="col-sm-2 control-label required-label">Present
							Address</label>
						<div class="col-sm-10">
							<div class="input-group">
								<textarea id="presentAddress" name="presentAddress" class="form-control" rows="5"
									cols="50" placeholder="Present Address" required></textarea>
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="permanentAddress" class="col-sm-2 control-label">Permanent
							Address</label>
						<div class="col-sm-10">
							<textarea id="permanentAddress" name="permanentAddress" class="form-control" rows="5"
								cols="50" placeholder="Permanent Address"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label required-label">Email</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="email" name="emailAddress" class="form-control" type="email"
									placeholder="Email Address" required /> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="mobile" class="col-sm-2 control-label required-label">Mobile
							Number</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input type="tel" name="mobileNumber" class="form-control"
									placeholder="Mobile Number" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">Telephone
							Number</label>
						<div class="col-sm-10">
							<input type="tel" name="telephoneNumber" class="form-control"
								placeholder="Telephone Number">
						</div>
					</div>
					<div class="form-group">
						<label for="citizenship" class="col-sm-2 control-label">Citizenship</label>
						<div class="col-sm-10">
							<input id="citizenship" name="citizenship" type="text" class="form-control"
								placeholder="Citizenship">
						</div>
					</div>
					<!-- ------------------------------------------ SECOND SECTION ---------------------- -->
					<div class="form-group title" id="otherInformation">
						<h2>Other Information</h2>
					</div>
					<div class="form-group">
						<label for="education" class="col-sm-2 control-label">Educational
							Attainment</label>
						<div class="col-sm-10">
							<textarea id="education" name="educationAttainments" class="form-control" rows="5" cols="50"
								placeholder="Educational Attainment"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="achievements" class="col-sm-2 control-label">Achievements
							/ Certifications</label>
						<div class="col-sm-10">
							<textarea id="achievements" name="achievementsCertifications" class="form-control" rows="5"
								cols="50" placeholder="Achievements/Certifications"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="skills" class="col-sm-2 control-label">Skills</label>
						<div class="col-sm-10">
							<textarea id="skills" name="skills" class="form-control" rows="5" cols="50"
								placeholder="Skills"></textarea>
						</div>
					</div>
					<!-- ---------------------------------------- THIRD SECTION ----------------------------- -->
					<div class="form-group title" id="prevEmployment">
						<h2>Current/Previous Employment Information</h2>
					</div>
					<div class="form-group">
						<label for="company" class="col-sm-2 control-label">Company</label>
						<div class="col-sm-10">
							<input id="company" name="currentPreviousCompany" type="text" class="form-control"
								placeholder="Company">
						</div>
					</div>
					<div class="form-group">
						<label for="dateStart" class="col-sm-2 control-label">Date
							Started</label>
						<div class="col-sm-10">
							<input id="dateStart" name="currentPreviousDateStarted" placeholder="Date Started"
								class="form-control" type="text" onfocus="(this.type='date')"
								onblur="(this.type='text')">
						</div>
					</div>
					<div class="form-group">
						<label for="dateEnd" class="col-sm-2 control-label">Date
							Ended</label>
						<div class="col-sm-10">
							<input id="dateEnd" name="currentPreviousDateEnded" placeholder="Date Ended" class="form-control"
								type="text" onfocus="(this.type='date')"
								onblur="(this.type='text')">
						</div>
					</div>
					<div class="form-group">
						<label for="position" class="col-sm-2 control-label">Position</label>
						<div class="col-sm-10">
							<input id="position" name="currentPreviousPosition" type="text" class="form-control"
								placeholder="Position">
						</div>
					</div>
					<div class="form-group">
						<label for="manager" class="col-sm-2 control-label">Manager
							Name</label>
						<div class="col-sm-10">
							<input id="manager" name="currentPreviousManager" type="text" class="form-control"
								placeholder="Manager Name">
						</div>
					</div>
					<!-- ---------------------------------------------------- FOURTH SECTION ---------------------------- -->
					<div class="form-group title" id="appInformation">
						<h2>Application Information</h2>
					</div>
					<div class="form-group">
						<label for="positionApplied"
							class="col-sm-2 control-label required-label">Position
							Applying For</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="positionApplied" name="positionApplyingFor" type="text" class="form-control"
									placeholder="Position" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="availability"
							class="col-sm-2 control-label required-label">Availability
							of Employment</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="availability" name="availabilityOfEmployment"
									placeholder="Availability of Employment" class="form-control"
									type="text" onfocus="(this.type='date')"
									onblur="(this.type='text')" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					<div class="form-group title" id="uploadResume">
						<h2>Additional Attachments</h2>
					</div>
					<div class="form-group">
						<label for="resume" class="col-sm-2 control-label">Resume</label>
						<div class="col-sm-10">
							<input id="resume" name="resume" type="file" class="form-control" />
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
</body>
</html>
