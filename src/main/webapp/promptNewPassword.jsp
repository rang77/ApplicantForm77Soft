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
				<form class="form-horizontal" action="CreateNewPasswordServlet" method="post">
					<div class="form-group title login-title-custom" id="formTitle">
						LEAVE MANAGEMENT SYSTEM</div>
					<c:if test="${not empty error}">
						<div class="alert-danger alert-custom">
							<strong><c:out value="${error.message}" /></strong>
						</div>
					</c:if>
					<input type="hidden" name="loginid" value="${login.id}"/>
					<div class="form-group" style="margin-top: 22px">
						<label class="col-xs-4 control-label" for="newpassword1">New Password: </label>
						<div class="col-xs-8">
							<div class="input-group-xs">
								<input type="password" class="form-control" name="newpassword1" id="newpassword1"
									placeholder="Password" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-4 control-label" for="newpassword2">Confirm New Password:
						</label>
						<div class="col-xs-8">
							<div class="input-group-xs">
								<input type="password" class="form-control" name="newpassword2"
									id="newpassword2" placeholder="Password" />
							</div>
						</div>
					</div>
					<div class="form-group" style="margin-top: 22px">
						<label class="col-xs-4 control-label" for="email">Activation Code: </label>
						<div class="col-xs-8">
							<div class="input-group-xs">
								<input type="text" class="form-control" name="activation" id="activation"
									placeholder="Activation Code" />
							</div>
						</div>
					</div>					
					<div class="btn-group">
						<button type="submit" class="btn btn-danger">Confirm</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>