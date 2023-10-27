<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 BoardList **</title>
</head>
<body>
	<h2>** Spring_MVC2 BoardList **</h2>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${message}
	</c:if>
	<table border="1" style="width: 90%;">
		<tr bgcolor="DeepPink">
			<th>Seq</th>
			<th>Title</th>
			<th>ID</th>
			<th>Regdate</th>
			<th>조회수</th>

			<!-- 관리자 기능으로 추가 -->
			<c:if test="${sessionScope.loginID == 'admin'}">
				<th>Delete</th>
			</c:if>
		</tr>
		<c:if test="${!empty requestScope.banana}">
			<c:forEach var="m" items="${requestScope.banana}">
				<tr>
					<td>${m.seq}</td>

					<!-- 로그인 한 경우에만 detail 로 넘어가도록(글 내용을 볼 수 있도록) -->
					<c:if test="${!empty sessionScope.loginID}">
						<td>
							<a href="bdetail?seq=${m.seq}">
						<!-- indent 값에 따라 들여쓰기 기능 추가 -->
								<c:if test="${m.indent > 0}">
									<c:forEach begin="1" end="${m.indent}" >
										<span>&nbsp;&nbsp;</span>
									</c:forEach>
									<span style="color:blue;">re..)</span>
								</c:if>
								${m.title}
							</a>
						</td>
					</c:if>
					<c:if test="${empty sessionScope.loginID}">
						<td>${m.title}</td>
					</c:if>

					<td>${m.id}</td>
					<td>${m.regdate}</td>
					<td>${m.cnt}</td>
					<c:if test="${sessionScope.loginID == 'admin'}">
						<td><a href="bdelete?seq=${m.seq}&root=${m.root}">삭제</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.banana}">
			<tr>
				<td colspan="5">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<br>
	<c:if test="${!empty sessionScope.loginID}">
		<a href="boardInsert">새 글 등록</a>
	</c:if>
	<hr>
	&nbsp;
	<a href="/green/home">Home</a>
</body>
</html>