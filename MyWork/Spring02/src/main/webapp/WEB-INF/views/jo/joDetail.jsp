<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Jo Detail **</title>
</head>
<body>
	<h2>** Spring_MVC2 Jo Detail **</h2>
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	</c:if>
	<table border="1">
		<c:if test="${!empty requestScope.apple}">
			<tr height="40">
				<th bgcolor="plum">조 번호</th>
				<td>${requestScope.apple.jno}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">조 이름</th>
				<td>${requestScope.apple.jname}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">조장</th>
				<td>${requestScope.apple.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">프로젝트 명</th>
				<td>${requestScope.apple.project}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">Slogan</th>
				<td>${requestScope.apple.slogan}</td>
			</tr>
		</c:if>
		<c:if test="${empty requestScope.apple}">
			<tr>
				<td colspan="2">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<br><br>
	<table border="1">
		<tr>
			<th bgcolor="plum">ID</th>
			<th bgcolor="plum">Password</th>
			<th bgcolor="plum">Name</th>
			<th bgcolor="plum">Age</th>
			<th bgcolor="plum">Info</th>
			<th bgcolor="plum">Point</th>
			<th bgcolor="plum">Birthday</th>
			<th bgcolor="plum">Rid</th>
		</tr>
		<c:if test="${!empty requestScope.banana}">
			<c:forEach var="s" items="${requestScope.banana}">
				<tr>
					<td>${s.id}</td>
					<td>${s.password}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.info}</td>
					<td>${s.point}</td>
					<td>${s.birthday}</td>
					<td>${s.rid}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<br>
	<hr>
	<c:if test="${sessionScope.loginID == 'admin'}">
		<a href="joInsert">조 추가하기</a>&nbsp;&nbsp;
		<a href="jdetail?jCode=U&jno=${requestScope.apple.jno}">조 수정</a>&nbsp;&nbsp;
		<a href="jdelete?jno=${requestScope.apple.jno}">조 삭제</a>
	</c:if>
	<hr>
	&nbsp;
	<a href="/green/home">Home</a> &nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp;&nbsp;
	<a href="joList">리스트</a>
</body>
</html>