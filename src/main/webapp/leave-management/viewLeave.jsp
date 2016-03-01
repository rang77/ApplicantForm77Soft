<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<script src="/jquery/jquery-1.11.3.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<link href="/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" href="/css/neotheme.css" />
	<link rel="stylesheet" href="/css/form-elements-new.css" />
	
	<title>Seven Seven GSI | Leave Management</title>
	
		<script type="text/javascript" class="init">
	
		$(document).ready(function() {
			$('#myTable').DataTable( {
				"order": [[ 3, "desc" ]]
			} );
		} );

		</script>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top inverse-dark">
		<div class="container-fluid">
			<div class="col-sm-1"></div>
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
			<div class="col-sm-1"></div>
		</div>
	</nav>

	<div class="page-start container-fluid">
		<!-- Employee Information Section -->
		<div class="row-fluid container-fluid">
			<div class="container-fluid col-sm-5 col-sm-offset-1">		
				<div class="form-horizontal output-form" >
					<div class="form-group title" id="employeeInformation">
						<h2>Employee Information</h2>
					</div>	
					<div class="form-group">
						<label class="col-sm-3 control-label">ID Number: </label>
						<div class="col-sm-9">
							<div class="form-control"><c:out value="${employee.idNumber}"/></div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Full Name: </label>
						<div class="col-sm-9">
							<div class="form-control"><c:out value="${employee.lastName}, ${employee.firstName} ${employee.middleName}"/></div>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid col-sm-5">	
				<div class="form-horizontal output-form" >
					<div class="form-group title" id="leaveInformation">
						<h2>Leave Information</h2>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">VL Credits: </label>
						<div class="col-sm-9">
							<div class="form-control">
								<div class="progress">
									<span class="progress-value">${employee.vacationLeavesUsed} / ${employee.vlCredits} used</span>
									<div class="progress-bar progress-bar-danger" role="progressbar" 
										aria-valuenow="${employee.vacationLeavesUsed}" aria-valuemin="0" aria-valuemax="${employee.vlCredits}" 
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
									<span class="progress-value">${employee.sickLeavesUsed} / ${employee.slCredits} used</span>
									<div class="progress-bar progress-bar-danger" role="progressbar" 
										aria-valuenow="${employee.sickLeavesUsed}" aria-valuemin="0" aria-valuemax="${employee.slCredits}" 
										style="width:${(employee.sickLeavesUsed / employee.slCredits) * 100}%;">
								  	</div>
								 </div>
							</div>
						</div>
					</div>						
				</div>
			</div>
			<div class="clearfix visible-xs-block"></div>		
		</div>

		<!-- File Leave Section -->
		<div class="row container-fluid">
			<div class="container-fluid col-xs-12 col-sm-6 col-sm-offset-1 col-md-10">
				<form class="form-horizontal" action="/leave-management/fileLeave" method="POST">
					<input type="hidden" name="recordId" value="${employee.recordID}">
					<input type="hidden" name="idNumber" value="${employee.idNumber}">
					
					<div class="form-group title" id="fileLeave">
						<h2>File Leave</h2>
					</div>
<!-- 					<div class="well welldark-sm">
						<strong>
							<span class="glyphicon glyphicon-asterisk"></span>
							Required Field
						</strong>
					</div> -->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="leaveType">Leave Type: </label>
						<div class="col-sm-10">
							<div class="input-group">
								<select id="leaveType" name="leaveType" class="form-control">
									<option value="Vacation Leave">Vacation Leave</option>
									<option value="Sick Leave">Sick Leave</option>
								</select> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="startDate">Start Date:  </label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="startDate" name="startDate" placeholder="Start Date"
												class="form-control" type="text" onfocus="(this.type='date')"
												onblur="(this.type='text')" required>
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-asterisk"></span>
								</span>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="endDate">End Date:  </label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="endDate" name="endDate" placeholder="End Date"
												class="form-control" type="text" onfocus="(this.type='date')"
												onblur="(this.type='text')" required> 
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-asterisk"></span>
								</span>
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

		<!-- Leave Requests Section -->
		<div class="row container-fluid">
<!-- 			<div class="col-sm-12"> -->
			<div class="container-fluid col-xs-12 col-sm-6 col-sm-offset-1 col-md-10">
				<div class="title" id="leaveRequests">
					<h2>Leave Requests</h2>
				</div>
				<c:choose>
					<c:when test="${empty employee.leaveRequests}">
							<div class="alert alert-warning">
								<em>No Leave Requests Yet</em>
							</div>
					</c:when>
					<c:otherwise>
					
<!-- 					These are required files we must include these libraries  -->
					   
					<link rel="stylesheet" href="http://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css" />
					<script type="text/javascript" src="http://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
						<div class="table-responsive">
							<table id="myTable" width="100%" class="table table-striped">
								<thead>
									<tr>
										<th>#</th>
										<th>Leave Type</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Days on Leave</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${employee.leaveRequests}" var="leaveRequest">
										<tr>
											<td><c:out value="${leaveRequest.requestNumber}"/></td>
											<td><c:out value="${leaveRequest.leaveType}"/></td>
											<td><c:out value="${leaveRequest.startDate}"/></td>
											<td><c:out value="${leaveRequest.endDate}"/></td>
											<td><c:out value="${leaveRequest.daysOnLeave}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="clearfix visible-xs-block"></div>
		</div>
	</div>
	
</body>
</html>