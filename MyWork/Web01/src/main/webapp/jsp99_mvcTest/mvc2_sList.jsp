<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 StudentList **</title>
</head>
<body>
	<h2>** Web_MVC2 StudentList **</h2>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${message}
	</c:if>
	<table border="1" style="width: 90%;">
		<tr bgcolor="Lime">
			<th>sno</th>
			<th>name</th>
			<th>age</th>
			<th>jno</th>
			<th>info</th>
			<th>point</th>
			<th>birthday</th>
			
			<th>Delete</th>
		</tr>
		<c:if test="${!empty requestScope.banana}">
			<c:forEach var="list" items="${requestScope.banana}">
				<tr>
					<td>${list.sno}</td>
					<td>${list.name}</td>
					<td>${list.age}</td>
					<td>${list.jno}</td>
					<td>${list.info}</td>
					<td>${list.point}</td>
					<td>${list.birthday}</td>
					
					<td><a href="/Web01/delete?sno=${list.sno}">삭제</a></td>
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
	&nbsp; <a href="/Web01/index.jsp">Home</a>
</body>
</html>