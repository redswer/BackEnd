<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web02_Member **</title>
</head>
<body>
	<h2>** Hello Dynamic Web_Project **</h2>

	<c:if test="${!empty sessionScope.loginName}">
		<c:out value="${sessionScope.loginName}님 안녕하세요" /> 
	</c:if>
	<c:if test="${empty sessionScope.loginName}">
		<c:out value="로그인 후 이용하세요" />
	</c:if>
	<br>
	<hr>
	
	<img alt="" src="./image/a2.png" width="400" height="300">
	<hr>

	<c:if test="${!empty sessionScope.loginID}">
		&nbsp; <a href="/Web02/mlogout">Logout</a>
		<br>
		&nbsp; <a href="/Web02/mdetail">myInfo</a>
		&nbsp; <a href="/Web02/mdetail.do">myInfoF</a>
	</c:if>
	<c:if test="${empty sessionScope.loginID}">
		&nbsp; <a href="/Web02/member/loginForm.jsp">LoginF</a>
		&nbsp; <a href="/Web02/member/memberJoin.jsp">Join</a>
	</c:if>
	<br>

	<br>
	
	&nbsp; <a href="/Web02/mlist">List</a>
	&nbsp; <a href="/Web02/mlist.do">ListF</a>

</body>
</html>