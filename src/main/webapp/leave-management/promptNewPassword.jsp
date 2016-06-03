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

<title>Seven Seven GSI - Leave Management System</title>
</head>

<body>
	<div class="vertical-center">
		<div class="container">
			<div id="home" class="row">
				<img src="/img/77NewLogo.jpg" class="img-responsive" width="240px" />
				<form class="form-horizontal" action="create-new-password"
					method="post" onsubmit="return checkForm(this);">
					<div class="form-group title login-title-custom" id="formTitle">
						LEAVE MANAGEMENT SYSTEM</div>
					<jsp:include page="/leave-management/pageMessages.jsp"/>
					<div class="alert-info alert-custom">
						<strong><c:out value="Password must contain at least one number, 
						one lowercase and one uppercase letter, and must be at least six
						characters long." /></strong>
					</div>
					<input type="hidden" name="loginid" value="${login.id}" />
					<div class="form-group" style="margin-top: 22px">
						<label class="col-xs-4 control-label" for="newpassword1">New
							Password: </label>
						<div class="col-xs-8">
							<div class="input-group-xs">
								<input type="password" class="form-control" name="newpassword1"
									id="newpassword1" placeholder="Password" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-4 control-label" for="newpassword2">Confirm
							New Password: </label>
						<div class="col-xs-8">
							<div class="input-group-xs">
								<input type="password" class="form-control" name="newpassword2"
									id="newpassword2" placeholder="Password" />
							</div>
						</div>
					</div>
					<div class="form-group" style="margin-top: 22px">
						<label class="col-xs-4 control-label" for="email">Activation
							Code: </label>
						<div class="col-xs-8">
							<div class="input-group-xs">
								<input type="text" class="form-control" name="activation"
									id="activation" placeholder="Activation Code" />
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