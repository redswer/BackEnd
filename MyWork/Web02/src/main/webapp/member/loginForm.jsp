<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** servlet03_flow Student Login Test **</title>
</head>
<body>
<h2>** servlet03_flow Student Login Test **</h2>
<form action="/Web02/mlogin" method="get">
<table>
	<tr height="30"><td><label for="id">ID</label></td>
		<td><input type="text" id="id" name="id"></td>
	</tr>
	<tr height="30"><td><label for="password">Password</label></td>
		<td><input type="text" id="password" name="password"></td>
	</tr>
	<tr height="30"><td></td>
		<td><input type="submit" value="로그인">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
<hr>

<c:if test="${!empty requestScope.message}">
	<c:out value="${requestScope.message}"/>
</c:if>
</body>
</html>