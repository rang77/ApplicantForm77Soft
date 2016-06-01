<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${not empty messages}">
	<c:forEach var="message" items="messages.pageMessages">
		<c:choose>
			<c:when test="${message.info}">
				<c:set var="messageClass" value="alert-info" />
			</c:when>
			<c:when test="${message.success}">
				<c:set var="messageClass" value="alert-success" />
			</c:when>
			<c:when test="${message.warning}">
				<c:set var="messageClass" value="alert-warning" />
			</c:when>
			<c:when test="${message.error}">
				<c:set var="messageClass" value="alert-danger" />
			</c:when>
			<c:otherwise>
				<c:set var="messageClass" value="" />
			</c:otherwise>
		</c:choose>

		<div class="${messageClass} alert-custom">
			<strong><c:out value="${message}" /></strong>
		</div>
	</c:forEach>
</c:if>