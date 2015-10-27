<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

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
		Start Date: <fmt:formatDate type="date" value="${leaveRequest.startDate}"/><br/>
		End Date: <fmt:formatDate type="date" value="${leaveRequest.endDate}"/><br/>
		Days on Leave: <c:out value="${leaveRequest.daysOnLeave}"/><br/>
		<br/>
	</c:forEach>

</body>
</html>