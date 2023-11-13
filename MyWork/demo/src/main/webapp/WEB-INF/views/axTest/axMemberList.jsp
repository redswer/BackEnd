<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Axios MemberList **</title>
<link>
</head>
<body>
	<h2>** Spring_Boot Axios MemberList **</h2>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${message}
	</c:if>
	<table border="1" style="width: 100%;">
		<tr bgcolor="DeepSkyBlue">
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>jno</th>
			<th>info</th>
			<th>point</th>
			<th>birthday</th>
			<th>rid</th>
			<th>image</th>
			<th>이미지 다운로드</th>
			<!-- 관리자 기능으로 추가 -->
			<c:if test="${sessionScope.loginID == 'admin'}">
			<th>Delete</th>
			</c:if>
		</tr>
		<c:if test="${!empty requestScope.banana}">
			<c:forEach var="m" items="${requestScope.banana}">
				<tr>
					<td><a href="/member/mdetail?id=${m.id}">${m.id}</a></td>
					<td>${m.name}</td>
					<td>${m.age}</td>
					<td>${m.jno}</td>
					<td>${m.info}</td>
					<td>${m.point}</td>
					<td>${m.birthday}</td>
					<td>${m.rid}</td>
					<td>
						<img alt="MyImage" src="/${m.uploadfile}" width=70 height="70">
					</td>
					<td>
						<a href="download?dnfile=${m.uploadfile}">${m.uploadfile}</a>
					</td>
					
					<!-- Axios 로 삭제기능 처리 -->
					<!-- => 삭제할 대상을 function 에 전달 : 매개변수 활용 -->
					<c:if test="${sessionScope.loginID == 'admin'}">
						<td><span class="textlink" id="${m.id}" onClick="axiDelete('${m.id}')">삭제</span></td>
						<!-- axiDelete(${m.id}) -> axiDelete(banana)
							매개변수가 아닌 변수명으로 취급됨, 따라서 '' 사용해야 함 -->
						<!-- delete 시 글자 및 스타일 변경과 onclick 속성 제거를 위해
							id 를 각자 다르게 주어야 함 -> id 값으로 id 나 index 주로 활용 -->
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
	&nbsp; <a href="/home">Home</a>
</body>
</html>