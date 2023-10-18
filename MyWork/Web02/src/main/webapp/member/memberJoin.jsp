<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 Member Join **</title>
</head>
<body>
	<h2>** Web_MVC2 Member Join **</h2>
	<form action="/Web02/mjoin" method="post">
		<table border="1">
			<tr height="40">
				<th bgcolor="aqua">ID</th>
				<td>
					<input type="text" name="id" placeholder="영어+숫자, 10글자 이내" size="20"/>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Password</th>
				<td>
					<input type="password" name="password" placeholder="영어+슷자+특수문자" size="20"/>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Name</th>
				<td>
					<input type="text" name="name" placeholder="한글 또는 영어" size="20"/>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Age</th>
				<td>
					<input type="text" name="age" placeholder="숫자입력" size="20"/>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Jno</th>
				<td>
					<select name="jno">
						<option value="1">1조 (119조)</option>
						<option value="2">2조 (여우조)</option>
						<option value="3">3조 (i4조)</option>
						<option value="4">4조 (최고조)</option>
						<option value="5">5조 (오조)</option>
						<option value="7">7조 (관리팀)</option>
					</select>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Info</th>
				<td>
					<input type="text" name="info" placeholder="자기소개 & 희망사항" size="20"/>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Point</th>
				<td>
					<input type="text" name="point" placeholder="실수입력" size="20"/>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Birthday</th>
				<td>
					<input type="date" name="birthday" size="20"/>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Rid</th>
				<td>
					<input type="text" name="rid" placeholder="추천인" size="20"/>
				</td>
			</tr>
			<tr height="40">
				<td colspan="2" style="text-align:center;">
				<input type="submit" value="가입"/>
				&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소"/>
				</td>
			</tr>
	</table>
	</form>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	</c:if>
	<a href="/Web02/index.jsp">Home</a>&nbsp;&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp;&nbsp;
</body>
</html>