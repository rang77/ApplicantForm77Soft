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

<title>Seven Seven GSI - Leave Management System</title>
</head>

<body>
	<div class="vertical-center">
		<div class="container">
			<div id="home" class="row">
				<img src="/img/77NewLogo.jpg" class="img-responsive" width="240px" />
				<form class="form-horizontal" action="LoginServlet" method="post">
					<div class="form-group title login-title-custom" id="formTitle">
						LEAVE MANAGEMENT SYSTEM
					</div>				
					<div class="form-group">
						<label class="col-sm-4 control-label" for="idNumber">Id Number: </label>
						<div class="col-sm-8">
							<div class="input-group">
								<input type="text" class="form-control" name="idNumber" id="idNumber" placeholder="Id Number"/>
							</div>
						</div>
					</div>				
					<div class="form-group">
						<label class="col-sm-4 control-label" for="password">Password: </label>
						<div class="col-sm-8">
							<div class="input-group">
								<input type="password" class="form-control" name="password" id="password" placeholder="Password"/>
							</div>
						</div>
					</div>				
					<div class="btn-group">
						<button type="submit" class="btn btn-danger">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>