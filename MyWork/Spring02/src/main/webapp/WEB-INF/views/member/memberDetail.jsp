<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Detail **</title>
</head>
<body>
	<h2>** Spring_MVC2 Member Detail **</h2>
	<table border="1">
		<c:if test="${!empty requestScope.apple}">
			<tr height="40">
				<th bgcolor="pink">ID</th>
				<td>${requestScope.apple.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Password</th>
				<td>${requestScope.apple.password}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Name</th>
				<td>${requestScope.apple.name}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Age</th>
				<td>${requestScope.apple.age}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Jno</th>
				<td>${requestScope.apple.jno}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Info</th>
				<td>${requestScope.apple.info}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Point</th>
				<td>${requestScope.apple.point}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Birthday</th>
				<td>${requestScope.apple.birthday}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Rid</th>
				<td>${requestScope.apple.rid}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Image</th>
				<td><img alt="MyImage"
					src="/Spring02/${requestScope.apple.uploadfile}" width="80"
					height="80"></td>
			</tr>
		</c:if>
		<c:if test="${empty requestScope.apple}">
			<tr>
				<td colspan="2">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>
	&nbsp;
	<a href="/Spring02/home">Home</a> &nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>
</body>
</html>