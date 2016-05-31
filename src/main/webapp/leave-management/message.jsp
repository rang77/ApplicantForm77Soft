<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="/jquery/jquery-1.11.3.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/npm.js"></script>

<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/neotheme.css" />
<link rel="stylesheet" href="/css/lms.css" />

<style>
.alert-custom {
	padding: 5px;
	padding-left: 12px;
	padding-right: 12px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px
}
</style>

<title>Seven Seven GSI - Leave Management System</title>
</head>

<body>
	<div class="vertical-center">
		<div class="container">
			<div id="home" class="row">
				<img src="/img/77NewLogo.jpg" class="img-responsive" width="240px" />
				<form class="form-horizontal" action="ConfirmVerificationCode"
					method="post" onsubmit="return checkForm(this);">
					<div class="form-group title login-title-custom" id="formTitle">
						LEAVE MANAGEMENT SYSTEM</div>
					<c:if test="${not empty error}">
						<div class="alert-danger alert-custom">
							<strong><c:out value="${error.message}" /></strong>
						</div>
					</c:if>
					<c:if test="${not empty smessage}">
						<div class="alert-success alert-custom">
							<strong><c:out value="${smessage}" /></strong>
						</div>
					</c:if>
					<c:if test="${not empty imessage}">
						<div class="alert-info alert-custom">
							<strong><c:out value="${imessage}" /></strong>
						</div>
					</c:if>
				</form>
			</div>
		</div>
	</div>
</body>

</html>