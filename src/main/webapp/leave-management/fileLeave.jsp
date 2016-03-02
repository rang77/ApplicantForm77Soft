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

<script>
	$(function() {
		$("#startDate").datepicker({
			dateFormat : 'yy-mm-dd'
		}).val();
		$("#endDate").datepicker({
			dateFormat : 'yy-mm-dd'
		}).val();
	});
	$(document).ready(function() {
		$('#myTable').DataTable({
			"order" : [ [ 3, "desc" ] ]
		});
	});
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
			<a class="navbar-brand" href="../index.html"><img
				src="../img/77logo-black.png" class="img-responsive" width="120px" /></a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="mainNavbar">
			<ul class="nav navbar-nav">
				<li><a href="/leave-management/getLeaveCredits">Home</a></li>
				<li><a href="/leave-management/fileLeave.jsp">File Leave</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right navbar-right-custom">
				<li class=""><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Account Settings <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Change Password</a></li>
					</ul></li>
				<li><a href="/LogoutServlet">Logout</a></li>
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
					action="/leave-management/fileLeave" method="POST">
					<input type="hidden" name="recordId" value="${employee.recordID}">
					<input type="hidden" name="idNumber" value="${employee.idNumber}">

					<div class="form-group title" id="fileLeave">
						<h2>Create New Leave Request</h2>
					</div>
					<c:if test="${not empty error}">
						<div class="alert-danger alert">
							<strong><c:out value="${error.message}"/></strong>
						</div>
					</c:if>
					<div class="col-sm-6">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="leaveType">Leave
								Type: </label>
							<div class="col-sm-10">
								<div class="input-group">
									<select id="leaveType" name="leaveType" class="form-control">
										<option value="Vacation Leave">Vacation Leave</option>
										<option value="Sick Leave">Sick Leave</option>
									</select> <span class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="leaveReason">
								Reason: </label>
							<div class="col-sm-10">
								<div class="input-group">
									<input id="leaveReason" name="leaveReason" placeholder="Reason"
										class="form-control" type="text" required> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-asterisk"></span>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="col-sm-6">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="startDate">Start
								Date: </label>
							<div class="col-sm-10">
								<div class="input-group">
									<input id="startDate" name="startDate" placeholder="Start Date"
										class="form-control" type="text" required> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-asterisk"></span>
									</span>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="endDate">End
								Date: </label>
							<div class="col-sm-10">
								<div class="input-group">
									<input id="endDate" name="endDate" placeholder="End Date"
										class="form-control" type="text" required> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-asterisk"></span>
									</span>
								</div>
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
			<div class="clearfix visible-xs-block"></div>
		</div>
	</div>

</body>
</html>