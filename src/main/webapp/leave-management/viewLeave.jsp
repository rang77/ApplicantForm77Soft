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
	<link href="/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/css/dark-theme.css" />
	<link rel="stylesheet" href="/css/form-elements.css" />
	
	<title>Employee Details</title>
</head>
<body>

	<c:if test="${not empty requestID}">
		Successfully requested for leave
	</c:if>

	ID Number: <c:out value="${employee.idNumber}"/><br/>
	First Name: <c:out value="${employee.firstName}"/><br/>
	Last Name: <c:out value="${employee.lastName}"/><br/>
	Middle Name: <c:out value="${employee.middleName}"/><br/>
	VL Credits: <c:out value="${employee.vlCredits}"/><br/>
	Used VL Credits:<c:out value="${employee.usedVlCredits}"/><br/>
	SL Credits: <c:out value="${employee.slCredits}"/><br/>
	Used SL Credits: <c:out value="${employee.usedSlCredits}"/><br/>
	<br/>
	
	<c:forEach items="${employee.leaveRequests}" var="leaveRequest">
		Request Number: <c:out value="${leaveRequest.requestNumber}"/><br/>
		Leave Type: <c:out value="${leaveRequest.leaveType}"/><br/>
		Start Date: <fmt:formatDate pattern="MMMMM dd,yyyy zzz" value="${leaveRequest.startDate}"/><br/>
		End Date: <fmt:formatDate pattern="MMMMM dd,yyyy zzz" value="${leaveRequest.endDate}"/><br/>
		Days on Leave: <c:out value="${leaveRequest.daysOnLeave}"/><br/>
		<br/>
	</c:forEach>
	
	<hr/>
	
	<form action="/leave-management/fileLeave" method="POST">
		<input type="hidden" name="recordId" value="${employee.recordID}">
		<input type="hidden" name="idNumber" value="${employee.idNumber}">
		<div class="form-group title" id="primaryInformation">
			<h2>File Leave</h2>
		</div>
		<div class="form-group">
			<label for="firstName"
				class="col-sm-2 control-label required-label">Leave Type: </label>
			<div class="col-sm-10">
				<div class="input-group">
					<select id="leaveType" name="leaveType">
						<option disabled selected>Leave Type</option>
						<option value="Vacation Leave">Vacation Leave</option>
						<option value="Sick Leave">Sick Leave</option>
					</select> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label for="firstName"
				class="col-sm-2 control-label required-label">Start Date:  </label>
			<div class="col-sm-10">
				<div class="input-group">
					<input id="startDate" name="startDate" placeholder="Start Date"
									class="form-control" type="text" onfocus="(this.type='date')"
									onblur="(this.type='text')" required> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label for="firstName"
				class="col-sm-2 control-label required-label">End Date:  </label>
			<div class="col-sm-10">
				<div class="input-group">
					<input id="endDate" name="endDate" placeholder="End Date"
									class="form-control" type="text" onfocus="(this.type='date')"
									onblur="(this.type='text')" required> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="custom">
				<button type="submit" class="btncustom">Submit</button>
				<button type="reset" class="btncustom">Clear Fields</button>
			</div>
		</div>
	</form>

	<script src="/js/bootstrap.min.js"></script>
</body>
</html>