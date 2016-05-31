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
			"order" : [ [ 0, "desc" ] ]
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
					class="icon-bar"></span> <span class="icon-bar"></span>
				<!-- 				<span class="icon-bar"></span> -->
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/"><img
				src="../img/77logo-black.png" class="img-responsive" width="120px" /></a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="nav navbar-nav">
				<li><a href="/leave-management/getLeaveCredits">Home</a></li>
				<li><a href="/leave-management/fileLeave.jsp">File Leave</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right navbar-right-custom">
				<li class=""><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Account Settings <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/leave-management/changePassword.jsp">Change
								Password</a></li>
					</ul></li>
				<li><a href="/LogoutServlet">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="page-start container-fluid">
		<!-- Employee Information Section -->
		<div class="row-fluid container-fluid">
			<div class="container-fluid col-sm-10 col-sm-offset-1">
				<c:if test="${not empty smessage}">
					<div class="alert-success alert">
						<strong><c:out value="${smessage}" /></strong>
					</div>
				</c:if>
			</div>
			<div class="clearfix visible-xs-block"></div>
		</div>
		<div class="row-fluid container-fluid">
			<div class="container-fluid col-sm-5 col-sm-offset-1">
				<div class="form-horizontal output-form">
					<div class="form-group title" id="employeeInformation">
						<h2>
							<a data-toggle="collapse" href="#employeePanel"
								style="color: black; text-decoration: none;">Employee
								Information</a>
						</h2>
					</div>
					<div id="employeePanel" class="panel-collapse collapse in">
						<div class="form-group">
							<label class="col-sm-3 control-label">ID Number: </label>
							<div class="col-sm-9">
								<div class="form-control">
									<c:out value="${employee.idNumber}" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Full Name: </label>
							<div class="col-sm-9">
								<div class="form-control">
									<c:out
										value="${employee.lastName}, ${employee.firstName} ${employee.middleName}" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid col-sm-5">
				<div class="form-horizontal output-form">
					<div class="form-group title" id="leaveInformation">
						<h2>
							<a data-toggle="collapse" href="#leavePanel"
								style="color: black; text-decoration: none;">Leave
								Information</a>
						</h2>
					</div>
					<div id="leavePanel" class="panel-collapse collapse in">
						<div class="form-group">
							<label class="col-sm-3 control-label">VL Credits: </label>
							<div class="col-sm-9">
								<div class="form-control">
									<div class="progress">
										<span class="progress-value">${employee.vacationLeavesUsed}
											/ ${employee.vlCredits} used</span>
										<div class="progress-bar progress-bar-danger"
											role="progressbar"
											aria-valuenow="${employee.vacationLeavesUsed}"
											aria-valuemin="0" aria-valuemax="${employee.vlCredits}"
											style="width:${(employee.vacationLeavesUsed / employee.vlCredits) * 100}%;">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">SL Credits: </label>
							<div class="col-sm-9">
								<div class="form-control">
									<div class="progress">
										<span class="progress-value">${employee.sickLeavesUsed}
											/ ${employee.slCredits} used</span>
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="${employee.sickLeavesUsed}"
											aria-valuemin="0" aria-valuemax="${employee.slCredits}"
											style="width:${(employee.sickLeavesUsed / employee.slCredits) * 100}%;">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clearfix visible-xs-block"></div>
		</div>

		<!-- Leave Requests Section -->
		<div class="row container-fluid">
			<!-- 			<div class="col-sm-12"> -->
			<div
				class="container-fluid col-xs-12 col-sm-6 col-sm-offset-1 col-md-10">
				<div class="title" id="leaveRequests">
					<h2>
						<a data-toggle="collapse" href="#leavesTable"
							style="color: black; text-decoration: none;">Requested Leaves</a>
					</h2>
				</div>
				<c:choose>
					<c:when test="${empty employee.leaveRequests}">
						<div class="alert alert-warning">
							<em>No Leave Requests Yet</em>
						</div>
					</c:when>
					<c:otherwise>

						<!-- 					These are required files we must include these libraries  -->

						<link rel="stylesheet"
							href="http://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css" />
						<script type="text/javascript"
							src="http://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
						<div id="leavesTable" class="panel-collapse collapse in">
							<div class="table-responsive">
								<table id="myTable" width="100%" class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>Leave Type</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Halfday</th>
											<th>Days on Leave</th>
											<th>Reason</th>
											<th>Status</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${employee.leaveRequests}"
											var="leaveRequest">
											<tr>
												<td><c:out value="${leaveRequest.requestNumber}" /></td>
												<td><c:out value="${leaveRequest.leaveType}" /></td>
												<td><c:out value="${leaveRequest.startDate}" /></td>
												<td><c:out value="${leaveRequest.endDate}" /></td>
												<td><c:choose>
														<c:when test="${leaveRequest.halfday}">
														Yes
													</c:when>
														<c:otherwise>
														No
													</c:otherwise>
													</c:choose></td>
												<td><c:out value="${leaveRequest.daysOnLeave}" /></td>
												<td><c:out value="${leaveRequest.reason}" /></td>
												<td><c:out value="${leaveRequest.leaveStatus}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="clearfix visible-xs-block"></div>
		</div>
	</div>

</body>
</html>