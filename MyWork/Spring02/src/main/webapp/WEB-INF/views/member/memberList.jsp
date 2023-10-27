<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 MemberList **</title>
</head>
<body>
	<h2>** Spring_MVC2 MemberList **</h2>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${message}
	</c:if>
	<table border="1" style="width: 100%;">
		<tr bgcolor="Lime">
			<th>id</th>
			<th>password</th>
			<th>name</th>
			<th>age</th>
			<th>jno</th>
			<th>info</th>
			<th>point</th>
			<th>birthday</th>
			<th>rid</th>
			<th>image</th>
			<!-- 관리자 기능으로 추가 -->
			<c:if test="${sessionScope.loginID == 'admin'}">
			<th>Delete</th>
			</c:if>
		</tr>
		<c:if test="${!empty requestScope.banana}">
			<c:forEach var="m" items="${requestScope.banana}">
				<tr>
					<td><a href="mdetail?id=${m.id}">${m.id}</a></td>
					<td>${m.password}</td>
					<td>${m.name}</td>
					<td>${m.age}</td>
					<td>${m.jno}</td>
					<td>${m.info}</td>
					<td>${m.point}</td>
					<td>${m.birthday}</td>
					<td>${m.rid}</td>
					<td><img alt="MyImage" src="/green/${m.uploadfile}" width=70 height="70"></td>
					
					<c:if test="${sessionScope.loginID == 'admin'}">
						<td><a href="mdelete?id=${m.id}">삭제</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	 	<c:if test="${empty requestScope.banana}">
	 		<tr>
	 			<td colspan="7">출력할 데이터 없음</td>
	 		</tr>
	 	</c:if>
	</table>
	<hr>
	&nbsp; <a href="/green/home">Home</a>
</body>
</html>