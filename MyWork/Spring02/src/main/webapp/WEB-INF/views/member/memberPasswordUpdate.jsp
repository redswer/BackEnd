<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Password Update **</title>
</head>
<body>
	<h2>** Spring_MVC2 Member Password Update **</h2>
	<br>
	<hr>
	<form action="mpasswordupdate" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" value="${sessionScope.loginID}" readOnly>
				</td>
			</tr>
			<tr>
				<th>기존 비밀번호</th>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td>
					<input type="password" name="npassword">
				</td>
			</tr>
			<tr>
				<th>새 비밀번호 확인</th>
				<td>
					<input type="password" name="npasswordcheck">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	
&nbsp; <a href="/Spring02/home">Home</a>

</body>
</html>