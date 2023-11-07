<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** ID 중복 확인 **</title>
<script src="/resources/myLib/inCheck.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<style>
   body {
      background-color: LightYellow;
      font-family: 맑은고딕;
   }
   #wrap {
      margin-left: 0;
      text-align: center;
   }
   h3 { color: navy; }   
</style>
<script>
	function idOK() {
		//** idOK : 사용자가 입력한 id 를 사용가능하도록 해주고, 현재(this)창은 close
		//1) this 창의 id 를 부모창의 id 로
		//2) 부모창의 ID중복확인 버튼은 disable & submit 은 enable
		//3) 부모창의 id 는 수정불가 (readonly) , password 에 focus
		//4) 현재(this)창은 close
		
		opener.document.getElementById('id').value='${param.id}';
		// opener.document.getElementById('id').value= document.getElementById('id').value;
		// => 대신 el태그(${param.id}) 사용 가능 (jsp 문서에서만)
		
		opener.document.getElementById('idDup').disabled='disabled';
		opener.document.getElementById('submitTag').disabled='';
		
		// ** readonly 속성 사용시 주의
		//    Tag 의 속성은 readonly로 정의되어 있지만, 
		//    DOM 의 node 객체에서는 readOnly 로 정의되어있으므로
		//    JS 코딩시에는 readOnly 로 사용해야함
		opener.document.getElementById('id').readOnly='readOnly';	
		// opner.document.getElementById('id').readOnly=true;	
		// => 도 가능
		
		opener.document.getElementById('password').focus;	
		
		close();
		// => window.close(); 또는 self.close(); 도 가능
	}
</script>
</head>
<body>
	<div id="wrap">
		<h3>** ID 중복 확인 **</h3>
		<hr>
		<br>
		<form action="idDupCheck" method="get">
			<span>User_ID</span>
			<input type="text" id="id" name="id" value="${memberDTO.id}">
			<!-- memberDTO.id 와 param.id 모두 사용 가능 -->
			<input type="submit" value="중복 확인" onClick="return idCheck()">
			<!-- idCheck() 는 inCheck.js 에 정의되어 있음 -->
			<br>
			<span id="iMessage" class="eMessage"></span>
		</form>
		<br>
		<br>
		
		<!-- ** 서버의 처리결과 : idUse 의 값 'T'/'F' 에 따른 화면 -->
		<div id="msgBlock">
			<c:if test="${idUse == 'T'}">
				${param.id} 사용 가능&nbsp;&nbsp;
				<button onClick="idOK()">ID 선택</button>
			</c:if>
			<c:if test="${idUse == 'F'}">
				${param.id} 사용 불가능
				<script>
					document.getElementById('id').focus();
					opener.document.getElementById('id').value='';
				</script>
			</c:if>
		</div>
	</div>
</body>
</html>