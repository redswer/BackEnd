<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Jo Insert **</title>
</head>
<body>
	<h2>** Spring_Boot Jo Insert **</h2>
	<!-- 	<form action="join" method="post"> -->
	<form action="jinsert" method="post">
		<table border="1">
			<tr height="40">
				<th bgcolor="aqua">Jno</th>
				<td><input type="text" name="jno"
					placeholder="조 번호" /></td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">조 이름</th>
				<td><input type="text" name="jname" placeholder="조 이름" /></td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">조장 id</th>
				<td><input type="text" name="id" placeholder="조장의 id" /></td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">프로젝트 명</th>
				<td><input type="text" name="project" placeholder="프로젝트 이름" /></td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Slogan</th>
				<td><input type="text" name="slogan" placeholder="slogan" /></td>
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