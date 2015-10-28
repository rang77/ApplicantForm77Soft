<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Seven Seven GSI | Leave Management | Error</title>
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
		<div class="alert alert-danger">
			<strong>An error has occurred </strong>
			<c:if test="${not empty error}">
				<c:out value="${error.message}."/>
			</c:if>
			<c:choose>
				<c:when test="${not empty idNumber}">
					Return to <a href="/leave-management/getLeaveCredits?idNumber=${idNumber}">this page</a> to try again.
				</c:when>
				<c:otherwise>
					Return to <a href="/leave-management/leave.jsp">this page</a> to try again.
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>
