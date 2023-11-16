<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Jo Update **</title>
</head>
<body>
	<h2>** Spring_Boot Jo Update **</h2>
	<form action="jupdate" method="post">
		<table border="1">
			<c:if test="${!empty requestScope.apple}">
				<tr height="40">
					<th bgcolor="Orange">조 번호</th>
					<td><input type="text" name="jno"
						value="${requestScope.apple.jno}" readOnly /></td>
				</tr>
				<tr height="40">
					<th bgcolor="Orange">조 이름</th>
					<td><input type="text" name="jname"
						value="${requestScope.apple.jname}" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="Orange">조장 id</th>
					<td><input type="text" name="id"
						value="${requestScope.apple.id}" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="Orange">프로젝트 명</th>
					<td><input type="text" name="project"
						value="${requestScope.apple.project}" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="Orange">Slogan</th>
					<td><input type="text" name="slogan"
						value="${requestScope.apple.slogan}" /></td>
				</tr>
				<tr height="40">
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="수정" /> &nbsp;&nbsp;&nbsp; <input
						type="reset" value="취소" /></td>
				</tr>
			</c:if>
			<c:if test="${empty requestScope.apple}">
				<tr height="40">
					<td>수정할 자료가 존재하지 않음</td>
				</tr>
			</c:if>
		</table>
	</form>
	<hr>
	<a href="/home">Home</a>&nbsp;&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp;&nbsp;
</body>
</html>