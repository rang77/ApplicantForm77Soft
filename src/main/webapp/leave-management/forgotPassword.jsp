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
<link rel="stylesheet" href="/css/page-messages.css" />

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

<script type="text/javascript">
	function checkEmail(form) {
		if (form.email.value == "") {
			alert("Please enter an email address.");
			form.email.focus();
			return false;
		}
		return true;
	}
</script>

<title>Seven Seven GSI - Leave Management System</title>
</head>

<body>
	<div class="vertical-center">
		<div class="container">
			<div id="home" class="row">
				<img src="/img/77NewLogo.jpg" class="img-responsive" width="240px" />
				<form class="form-horizontal" action="forgot-password"
					method="post" onsubmit="return checkEmail(this);">
					<div class="form-group title login-title-custom" id="formTitle">
						LEAVE MANAGEMENT SYSTEM</div>
					<jsp:include page="/leave-management/pageMessages.jsp"/>
					<input type="hidden" name="id" value="${id}" />
					<input type="hidden" name="type" value="${type}" />
					<div class="form-group" style="margin-top: 22px">
						<label class="col-xs-3 control-label" for="email">Email: </label>
						<div class="col-xs-9">
							<div class="input-group-xs">
								<input type="email" class="form-control" name="email"
									id="email" placeholder="Email" />
							</div>
						</div>
					</div>
					<div class="btn-group">
						<button type="submit" class="btn btn-danger">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>