<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title><spring:message code="congrats" /> | webflow-tutorial</title>
	<link rel="icon" type="image/x-icon" href="<c:url value="/resources/images/favicon.ico" />">
	
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">

</head>

<body>
	<div class="container">
		<div class="row text-right">
			<span class="col-xs-12 text-right">
				<a href="?lang=en"><spring:message code="en" /></a>
				<a href="?lang=ru"><spring:message code="ru" /></a>
			</span>
		</div>
		<div class="jumbotron">
			
			<h1><spring:message code="congrats" />!</h1>
			<h3>Phone: ${phoneInfo.phone }</h3>
			<h3>Balance: ${phoneInfo.balance }</h3>
		</div>
	</div>

	<script src="<c:url value="/resources/js/jquery-1.12.0.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>