<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello spring!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	</c:if>
	<hr>
	<a href="mlist">MList</a> &nbsp;&nbsp;
	<a href="mlistsp">MList</a>
	<!-- MyHandlerMapping 의 mappings 요청명 확인 -->
</body>
</html>
