<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Member Login Test **</title>
</head>
<body>
<h2>** Spring_Boot Member Login Test **</h2>
<form action="login" method="post">
<table>
	<tr height="30"><td><label for="id">ID</label></td>
		<td><input type="text" id="id" name="id"></td>
	</tr>
	<tr height="30"><td><label for="password">Password</label></td>
		<td><input type="password" id="password" name="password"></td>
	</tr>
	<tr height="30"><td></td>
		<td><input type="submit" value="로그인">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
<c:if test="${!empty requestScope.message}">
	<br>
	<c:out value="${requestScope.message}"/>
</c:if>
<hr>
<!-- &nbsp; <a href="home">Home</a> -->
&nbsp; <a href="/home">Home</a>
</body>
</html>