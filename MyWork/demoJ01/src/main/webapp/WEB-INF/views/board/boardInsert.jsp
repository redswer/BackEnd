<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Board Insert **</title>
</head>
<body>
	<h2>** Spring_Boot Board Insert **</h2>
	<!-- 	<form action="join" method="post"> -->
	<form action="binsert" method="post">
		<table border="1">
			<tr height="40">
				<th bgcolor="aqua">ID</th>
				<td><input type="text" name="id"
					value="${sessionScope.loginID}" size="20" readOnly /></td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Title</th>
				<td><input type="text" name="title" placeholder="제목" /></td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Content</th>
				<td><textarea rows="5" cols="50" name="content"></textarea></td>
			</tr>
			<tr height="40">
				<td colspan="2" style="text-align: center;">
				<input type="submit" value="등록" />&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소" />
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	</c:if>
	<!-- 	<a href="home">Home</a>&nbsp;&nbsp; -->
	<a href="/home">Home</a>&nbsp;&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp;&nbsp;
</body>
</html>