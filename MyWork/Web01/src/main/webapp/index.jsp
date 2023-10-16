<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web01_JSP **</title>
</head>
<body>
	<h2>** Hello Dynamic Web_Project **</h2>
<%--<% if (session.getAttribute("loginName") != null) { %>
	<%= session.getAttribute("loginName")+"님 안녕하세요" %>
	<% } else { %>
	<%= "로그인 후 이용하세요" %>
	<% } %>
	--%>
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
	
<!--&nbsp; <a href="/Web01/servletTestForm/flowEx04_LoginForm.jsp">LoginF</a>
	&nbsp; <a href="/Web01/logout">Logout</a>
	-->
	<c:if test="${!empty sessionScope.loginName}">
		&nbsp; <a href="/Web01/logout">Logout</a>
		<br>
		&nbsp; <a href="/Web01/detail">myInfo</a>
	</c:if>
	<c:if test="${empty sessionScope.loginName}">
		&nbsp; <a href="/Web01/servletTestForm/flowEx04_LoginForm.jsp">LoginF</a>
		&nbsp; <a href="/Web01/jsp99_mvcTest/mvc2_sJoin.jsp">Join</a>
	</c:if>
	<br>
	
	&nbsp; <a href="/Web01/helloS">HelloServlet</a>
	&nbsp; <a href="/Web01/lifecycle">ServletLF</a>
	<br>
	
	&nbsp; <a href="/Web01/flow01">Flow01</a>
	&nbsp; <a href="/Web01/servletTestForm/flow02_TestForm.jsp">Flow02_TestForm.jsp</a>
	<br>
	
	&nbsp; <a href="/Web01/sessioni">SessionInfo</a>
	<br>
	
	&nbsp; <a href="/Web01/01set">ScopeTest</a>
	<br>
	
	&nbsp; <a href="/Web01/list2">List2</a>

</body>
</html>