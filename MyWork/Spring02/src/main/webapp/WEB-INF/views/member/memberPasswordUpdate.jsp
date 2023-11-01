<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Password Update **</title>
<script>
	function pCheck() {
		let pvalue = document.getElementById('password').value;
		
		if (pvalue.length < 4) {
			alert('4글자 이상 입력');
			return false;
		} else if (pvalue != document.getElementById('npassword').value) {
			alert('일치하지 않음');
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<h2>** Spring_MVC2 Member Password Update **</h2>
	<br>
	<hr>
	<form action="mpasswordupdate" method="post">
		<table>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password" id="password">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" name="npassword" id="npassword" onblur="pCheck()">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="수정" onClick="return pCheck()">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	
&nbsp; <a href="/Spring02/home">Home</a>

</body>
</html>