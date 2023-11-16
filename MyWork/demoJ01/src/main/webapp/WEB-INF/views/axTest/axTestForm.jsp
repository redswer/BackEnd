<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Ajax Test Main Form **</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/resources/myLib/jquery-3.2.1.min.js"></script>
<script src="/resources/myLib/axTest01.js"></script>
<script src="/resources/myLib/axTest02.js"></script>
<script src="/resources/myLib/axTest03.js"></script>
</head>
<body>
	<h2>** Ajax Test Main Form **</h2>
	<hr>
	<c:if test="${!empty sessionScope.loginID}">
		<img alt="MyImage" src="/${sessionScope.img}" border="1" width="50" height="50">
		${sessionScope.loginName}님 안녕하세요
	<br>
	<hr>
	</c:if>
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	<br>
	<hr>
	</c:if>
	&nbsp;<span class="textlink" onclick="rsLoginf()">rsLogin</span>
	&nbsp;<span class="textlink" onclick="rsJoinf()">rsJoin</span>
	&nbsp;<span class="textlink" onclick="axiMList()">axiMList</span>
	&nbsp;<a href="/home">[Home]</a>
	<hr>
	<div id="resultArea1"></div>
	<div id="resultArea2"></div>
</body>
</html>