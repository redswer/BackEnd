<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 JoList **</title>
</head>
<body>
	<h2>** Spring_MVC2 JoList **</h2>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${message}
	</c:if>
	<table border="1" style="width: 50%;">
		<tr bgcolor="DeepPink">
			<th>Jno</th>
			<th>Jname</th>

			<!-- 관리자 기능으로 추가 -->
			<c:if test="${sessionScope.loginID == 'admin'}">
				<th>Delete</th>
			</c:if>
		</tr>
		<c:if test="${!empty requestScope.banana}">
			<c:forEach var="m" items="${requestScope.banana}">
				<tr>
					<td><a href="jdetail?jno=${m.jno}">${m.jno}</a></td>
					<td>${m.jname}</td>
					<c:if test="${sessionScope.loginID == 'admin'}">
						<td><a href="jdelete?jno=${m.jno}">삭제</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.banana}">
			<tr>
				<td colspan="2">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<br>
	<c:if test="${sessionScope.loginID == 'admin'}">
		<a href="joInsert">조 추가</a>
	</c:if>
	<hr>
	&nbsp;
	<a href="/green/home">Home</a>
</body>
</html>