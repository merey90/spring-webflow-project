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

	<title><spring:message code="phone_payment" /> | webflow-tutorial</title>
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
			
			<div class="row">
				<form:form method="POST" modelAttribute="phonePayment" class="form col-xs-12 col-sm-6 col-sm-offset-3 form-vertical">
					<h3><spring:message code="phone_payment" /></h3>
					<div class="form-group">
						<form:label path="phone">
							<spring:message code="phone_label" />
						</form:label>
						<form:input path="phone" class="form-control" />
					</div>
					<div class="form-group">
						<form:label path="creditId">
							<spring:message code="creditId_label" />
						</form:label>
						<form:select path="creditId" class="form-control">
							<c:forEach items="${creditCards}" var="card">
								<form:option value="${card.id }"> * ${card.cardSecret }</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="form-group">
						<form:label path="balance">
							<spring:message code="balance_label" />
						</form:label>
						<form:input path="balance" class="form-control" />
						<c:if test="${not empty flowRequestContext.messageContext.allMessages }">
							<ul class="list-unstyled text-right">
								<c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
									<c:choose>
										<c:when test="${message.severity eq 'INFO'}">
											<c:set var="labelClass" value="label-success"/>
										</c:when>
										<c:when test="${message.severity eq 'ERROR'}">
											<c:set var="labelClass" value="label-danger"/>
										</c:when>
										<c:otherwise>
											<c:set var="labelClass" value="label-info"/>
										</c:otherwise>
									</c:choose>
									<li>
										<span class="label ${labelClass}">${message.text}</span>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
					<div class="form-group btn-group">
						<button class="btn btn-default" type="submit" name="_eventId_cancel"><spring:message code="cancel"/></button>
						<button class="btn btn-primary" type="submit" name="_eventId_submit"><spring:message code="submit"/></button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<script src="<c:url value="/resources/js/jquery-1.12.0.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>