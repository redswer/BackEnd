<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Reply Insert **</title>
</head>
<body>
	<h2>** Spring_Boot Reply Insert **</h2>
	<!-- 	<form action="join" method="post"> -->
	<form action="rinsert" method="post">
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
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="등록" />&nbsp;&nbsp;&nbsp; <input type="reset"
					value="취소" /></td>
			</tr>
		</table>
		<!-- 부모 글의 root, step, indent 가 있어야 댓글 등록 가능
			=> 그러므로 이 값들을 hidden 으로 보관했다가 서버로 전달 되도록 함
		 -->
		<input type="hidden" name="root" value="${boardDTO.root}" />
		<input type="hidden" name="step" value="${boardDTO.step}" />
		<input type="hidden" name="indent" value="${boardDTO.indent}" />
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