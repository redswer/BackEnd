<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
</head>
<body>
<h1>
	Hello Spring Boot!  
</h1>

<P>* Server Time : ${serverTime}</P>
<hr>

<c:if test="${!empty sessionScope.loginID}">
	<img alt="MyImage" src="/${sessionScope.img}" border="1" width="50" height="50">
	${sessionScope.loginName}님 안녕하세요
	<br>
</c:if>
<c:if test="${!empty requestScope.message}">
	${requestScope.message}
	<br>
</c:if>
<hr>

<img alt="mainImage" src="/resources/image/tulips.png" width="300" height="200">
<hr>

<c:if test="${empty sessionScope.loginID}">
<!--&nbsp;<a href="login">Login_Get</a>&nbsp;
	&nbsp;<a href="join">Join_Get</a> -->
	<!-- 계층적 url 적용 -->
	&nbsp;<a href="member/loginForm">Login_Get</a>&nbsp;
	&nbsp;<a href="member/memberJoin">Join_Get</a>
</c:if>
<c:if test="${!empty sessionScope.loginID}">
	&nbsp;<a href="member/logout">로그아웃</a>&nbsp;
	&nbsp;<a href="member/mdetail?id=${sessionScope.loginID}">내 정보</a>&nbsp;
	&nbsp;<a href="member/mdetail?jCode=U&id=${sessionScope.loginID}">내 정보 수정</a>&nbsp;
	&nbsp;<a href="member/memberPasswordUpdate?id=${sessionScope.loginID}">패스워드 수정</a>&nbsp;
	&nbsp;<a href="member/mdelete?id=${sessionScope.loginID}">탈퇴</a>&nbsp;
</c:if>
<br>
<!-- &nbsp;<a href="mlist">mList</a> -->
&nbsp;<a href="member/memberList">mList</a>

<br>
<hr>
&nbsp;<a href="board/boardList">bList</a>&nbsp;
&nbsp;<a href="board/bcriList">bcriList</a>
<br>
<hr>
&nbsp;<a href="jo/joList">조 List</a>
<br>
<hr>
</body>
</html>
