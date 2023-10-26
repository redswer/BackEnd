<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board Update **</title>
</head>
<body>
	<h2>** Spring_MVC2 Board Update **</h2>
	<form action="bupdate" method="post">
		<table border="1">
			<c:if test="${!empty requestScope.apple}">
				<tr height="40">
					<th bgcolor="Chocolate">Seq</th>
					<td><input type="text" name="seq"
						value="${requestScope.apple.seq}" readOnly /></td>
				</tr>
				<tr height="40">
					<th bgcolor="Chocolate">ID</th>
					<td><input type="text" name="id"
						value="${requestScope.apple.id}" readOnly /></td>
				</tr>
				<tr height="40">
					<th bgcolor="Orange">Title</th>
					<td><input type="text" name="title"
						value="${requestScope.apple.title}" size="50" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="Orange">Content</th>
					<td><textarea name="content" rows="5" cols="50">${requestScope.apple.content}</textarea></td>
				</tr>
				<tr height="40">
					<th bgcolor="Chocolate">RegDate</th>
					<td><input type="text" name="regdate"
						value="${requestScope.apple.regdate}" readOnly /></td>
				</tr>
				<tr height="40">
					<th bgcolor="Chocolate">조회수</th>
					<td><input type="text" name="cnt"
						value="${requestScope.apple.cnt}" readOnly /></td>
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
	<a href="/green/home">Home</a>&nbsp;&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp;&nbsp;
</body>
</html>