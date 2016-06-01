<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="/jquery/jquery-1.11.3.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="/js/bootstrap.min.js"></script>
<link href="/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/css/neotheme.css" />
<link rel="stylesheet" href="/css/form-elements-new.css" />

<script type="text/javascript">
	function checkPassword(str) {
		var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
		return re.test(str);
	}

	function checkForm(form) {
		if (form.newpassword1.value != form.newpassword2.value) {
			alert("The passwords you have entered do not match.");
			form.newpassword1.focus();
			return false;
		} else if (form.newpassword1.value == "" || !checkPassword(form.newpassword1.value)) {
			alert("The password you have entered is not valid. Please make sure that your password "
					+ "contains at least one number, one lowercase and one uppercase letter, and "
					+ "must be at least six characters long.");
			form.newpassword1.focus();
			return false;
		}
		
		return true;
	}
</script>

<title>Seven Seven GSI | Leave Management</title>

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top inverse-dark">
	<div class="container-fluid">
		<div class="col-sm-1"></div>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/"><img
				src="../img/77logo-black.png" class="img-responsive" width="120px" /></a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="nav navbar-nav">
				<li><a href="/leave-management/get-leave-credits">Home</a></li>
				<li><a href="/leave-management/fileLeave.jsp">File Leave</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right navbar-right-custom">
				<li class=""><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Account Settings <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/leave-management/changePassword.jsp">Change Password</a></li>
					</ul></li>
				<li><a href="/logout">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="page-start container-fluid">
		<!-- File Leave Section -->
		<div class="row container-fluid">
			<div
				class="container-fluid col-xs-12 col-sm-6 col-sm-offset-1 col-md-10">
				<form role="form" class="form-horizontal"
					action="change-password" method="POST" onsubmit="return checkForm(this);">

					<div class="form-group title" id="fileLeave">
						<h2>Change Password</h2>
					</div>
					<c:if test="${not empty error}">
						<div class="alert-danger alert">
							<strong><c:out value="${error.message}" /></strong>
						</div>
					</c:if>
					<c:if test="${not empty smessage}">
						<div class="alert-success alert">
							<strong><c:out value="${smessage}" /></strong>
						</div>
					</c:if>
					<div class="col-sm-12">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="oldpassword">Old
								Password: </label>
							<div class="col-sm-10">
								<div class="input-group">
									<input id="oldpassword" name="oldpassword"
										placeholder="Old Password" class="form-control" type="password"
										value="${oldpassword}" required> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-asterisk"></span>
									</span>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="newpassword1">
								New Password: </label>
							<div class="col-sm-10">
								<div class="input-group">
									<input id="newpassword1" name="newpassword1"
										placeholder="New Password" class="form-control" type="password"
										value="${newpassword1}" required> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-asterisk"></span>
									</span>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label" for="newpassword2">
								Confirm New Password: </label>
							<div class="col-sm-10">
								<div class="input-group">
									<input id="newpassword2" name="newpassword2"
										placeholder="Confirm New Password" class="form-control" type="password"
										value="${newpassword2}" required> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-asterisk"></span>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="custom">
							<button type="submit" class="btncustom">Submit</button>
						</div>
					</div>
				</form>
			</div>
			<div class="clearfix visible-xs-block"></div>
		</div>
	</div>

</body>
</html>