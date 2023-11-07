<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Member Update **</title>
<script src="/demo/resources/myLib/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>** Spring_Boot Member Update **</h2>
	<form action="mupdate" method="post" enctype="multipart/form-data">
		<table border="1">
			<c:if test="${!empty requestScope.apple}">
				<tr height="40">
					<th bgcolor="khaki">ID</th>
					<td><input type="text" name="id" placeholder="영어+숫자, 10글자 이내"
						value="${requestScope.apple.id}" size="20" readOnly /></td>
				</tr>
				<!-- id: 화면 출력은 되어야 하나 수정은 불가해야 함 (input 태그의 입력 막기)
					-> readOnly: 서버로 전송됨
					-> disabled: 서버로 전송되지 않음
				 -->
				<%-- 				<tr height="40">
					<th bgcolor="khaki">Password</th>
					<td><input type="password" name="password"
						placeholder="영어+슷자+특수문자" value="${requestScope.apple.password}"
						size="20" /></td>
				</tr> --%>
				<!-- password 는 기본적으로 복호화가 불가능하게 암호화되어 있으므로 
					별도로 처리 (본인 재 인증 후 변경)
				 -->
				<tr height="40">
					<th bgcolor="khaki">Name</th>
					<td><input type="text" name="name" placeholder="한글 또는 영어"
						value="${requestScope.apple.name}" size="20" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Age</th>
					<td><input type="text" name="age" placeholder="숫자입력"
						value="${requestScope.apple.age}" size="20" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Jno</th>
					<td><select name="jno">
							<option value="1"
								${requestScope.apple.jno == 1 ? "selected" : ""}>1조
								(119조)</option>
							<option value="2"
								${requestScope.apple.jno == 2 ? "selected" : ""}>2조
								(여우조)</option>
							<option value="3"
								${requestScope.apple.jno == 3 ? "selected" : ""}>3조
								(i4조)</option>
							<option value="4"
								${requestScope.apple.jno == 4 ? "selected" : ""}>4조
								(최고조)</option>
							<option value="5"
								${requestScope.apple.jno == 5 ? "selected" : ""}>5조
								(오조)</option>
							<option value="7"
								${requestScope.apple.jno == 7 ? "selected" : ""}>7조
								(관리팀)</option>
					</select></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Info</th>
					<td><input type="text" name="info" placeholder="자기소개 & 희망사항"
						value="${requestScope.apple.info}" size="20" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Point</th>
					<td><input type="text" name="point" placeholder="실수입력"
						value="${requestScope.apple.point}" size="20" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Birthday</th>
					<td><input type="date" name="birthday"
						value="${requestScope.apple.birthday}" size="20" /></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Rid</th>
					<td><input type="text" name="rid" placeholder="추천인"
						value="${requestScope.apple.rid}" size="20" /></td>
				</tr>
				<!-- Image Update 추가 
         => form Tag : method, enctype 확인
         => new Image 를 선택하는 경우 -> uploadfilef 사용
         => new Image 를 선택하지않는 경우 
            -> 본래 Image 를 사용 -> uploadfile 값이 필요함
   -->
				<tr height="40">
					<th bgcolor="khaki">MyImage</th>
					<td>
						<img alt="MyImage" width="80" height="100" class="select_img"
						src="/${requestScope.apple.uploadfile}">
						<br>
						<input type="hidden"
						name="uploadfile" value="${requestScope.apple.uploadfile}">
						<input type="file" name="uploadfilef" id="uploadfilef" size="20" /></td>
				</tr>
				<script>
					document.getElementById('uploadfilef').onchange = function(
							e) {
						if (this.files && this.files[0]) {
							let reader = new FileReader;
							reader.readAsDataURL(this.files[0]);
							reader.onload = function(e) {
								$(".select_img").attr("src", e.target.result)
										.width(70).height(90);
							}
						}
					};
				</script>
				<tr height="40">
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="수정" /> &nbsp;&nbsp;&nbsp; <input
						type="reset" value="취소" /></td>
				</tr>
			</c:if>
			<c:if test="${empty requestScope.apple}">
				<tr height="40">
					<td>수정할 자료가 존재하지 않음</td>
				</tr>
			</c:if>
		</table>
	</form>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	</c:if>
	<a href="/home">Home</a>&nbsp;&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp;&nbsp;
</body>
</html>