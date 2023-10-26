<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board Detail **</title>
</head>
<body>
	<h2>** Spring_MVC2 Board Detail **</h2>
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	</c:if>
	<table border="1">
		<c:if test="${!empty requestScope.apple}">
			<tr height="40">
				<th bgcolor="plum">Seq</th>
				<td>${requestScope.apple.seq}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">ID</th>
				<td>${requestScope.apple.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">Title</th>
				<td>${requestScope.apple.title}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">Content</th>
				<td>${requestScope.apple.content}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">RegDate</th>
				<td>${requestScope.apple.regdate}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">조회수</th>
				<td>${requestScope.apple.cnt}</td>
			</tr>
		</c:if>
		<c:if test="${empty requestScope.apple}">
			<tr>
				<td colspan="2">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<br>
	<hr>
	<!-- 로그인 한 경우에는 새 글 등록, 답글 등록 가능하도록 -->
	<c:if test="${!empty sessionScope.loginID}">
		<a href="boardInsert">새 글 쓰기</a>&nbsp;&nbsp;
		
		<!-- 댓글 등록을 위해 root, step, indent 값을 서버로 전송해야 함 -->
		<!-- 편의 상 requestScope 생략 -->
		<a href="replyInsert?root=${apple.root}&step=${apple.step}&indent=${apple.indent}">답 글 쓰기</a>&nbsp;&nbsp;
	</c:if>
	<br>
	<br>
	<!-- 로그인 id 와 글쓴이의 id 가 동일하면 수정이 가능하도록 -->
	<c:if test="${sessionScope.loginID == requestScope.apple.id}">
		<a href="bdetail?jCode=U&seq=${requestScope.apple.seq}">수정</a>&nbsp;&nbsp;
	<a href="bdelete?seq=${requestScope.apple.seq}">삭제</a>
	</c:if>
	<hr>
	&nbsp;
	<a href="/green/home">Home</a> &nbsp;
	<a href="boardList">이전으로</a>
</body>
</html>