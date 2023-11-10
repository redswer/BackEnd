<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Member Join **</title>
<script src="/resources/myLib/jquery-3.2.1.min.js"></script>
<script src="/resources/myLib/inCheck.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<script>
"use strict";
	// ** id 중복확인

	// ** 입력값의 무결성 점검
	// 1) 모든항목  focusout 이벤트핸들러
	//    => 개별항목 점검확인하는 boolean Type 변수 (스위치변수) 
	//    => 개별항목 점검 function() 작성
	// 2) submit 진행전에 점검확인
	//    => 모든항목의 점검이 완료된 경우에만  submit 진행
	//    => function inCheck() 로 확인
	//    => submit 버튼의 onclick 리스너에 등록
	//       ( submit 의 default 이벤트 고려 )

	// 1. switch 변수 정의
	let iCheck = false;
	let pCheck = false;
    let p2Check = false;
	let nCheck = false;
	let aCheck = false;
	let bCheck = false;
	let oCheck = false;

	// 2. 개별적으로 확인
	// => 이벤트: focusout, keydown_EnterKey 적용
	// => 오류가 없으면: switch 변수값을 true로, 메시지삭제 
	// => 오류가 있다면: switch 변수값을 false로, 메시지출력   
	// => 순서: Tag인식 -> Tag의 value가져오기 -> 무결성확인
	onload = function () {
        document.getElementById('id').addEventListener('keydown'
                , (e) => {
                    if (e.which == 13) {
                        e.preventDefault();
                        document.getElementById('password').focus();
                    }
                });
        
        document.getElementById('id').addEventListener('focusout', () => { iCheck = idCheck(); });
        document.getElementById('password').addEventListener('focusout', () => { pCheck = pwCheck(); });
        document.getElementById('password2').addEventListener('focusout', () => { p2Check = pw2Check(); });
        document.getElementById('name').addEventListener('focusout', () => { nCheck = nameCheck(); });
        document.getElementById('age').addEventListener('focusout', () => { aCheck = ageCheck(); });
        document.getElementById('birthday').addEventListener('focusout', () => { bCheck = bdCheck(); });
        document.getElementById('point').addEventListener('focusout', () => { oCheck = poCheck(); });
	}
	
    function inCheck() {
        if (iCheck == false) { document.getElementById('iMessage').innerHTML = '필수입력, id 는 4~10 글자 입니다.'; }
        if (pCheck == false) { document.getElementById('pMessage').innerHTML = '필수입력, Password 입력 하세요.'; }
        if (p2Check == false) { document.getElementById('p2Message').innerHTML = '필수입력, Password 확인'; }
        if (nCheck == false) { document.getElementById('nMessage').innerHTML = '필수입력, Name 입력 하세요.'; }
        if (aCheck == false) { document.getElementById('aMessage').innerHTML = '필수입력, Age 입력 하세요.'; }
        if (bCheck == false) { document.getElementById('bMessage').innerHTML = '필수입력, Brthday 입력 하세요.'; }
        if (oCheck == false) { document.getElementById('oMessage').innerHTML = '필수입력, Point 입력 하세요.'; }

        if (iCheck && pCheck && p2Check && nCheck && aCheck && bCheck && oCheck) {
            if (confirm('정말 가입하십니까 ? (Yes:확인 / No:취소)')) {
                return true;
            } else {
                alert('가입이 취소 되었습니다.');
                return false;
            }

        } else {
            return false;
        }
    }
    
    function idDupCheck() {
    	if (iCheck == false) {
    		iCheck = idCheck();
    	} else {
    		let url = "idDupCheck?id=" + document.getElementById('id').value;
    		window.open(url, '_blank', 'width=400,height=300,resizable=yes,scrollbars=yes,toolbar=no,menubar=yes');
    	}
    }
</script>
</head>
<body>
	<h2>** Spring_Boot Member Join **</h2>
	<!--  ** FileUpLoad Form **
=> form 과 table Tag 사용시 주의사항 : form 내부에 table 사용해야함
   -> form 단위작업시 인식안됨
   -> JQ 의 serialize, FormData 의 append all 등 

=> method="Post" : 255 byte 이상 대용량 전송 가능 하므로

=> <form enctype="속성값">
   <form> 태그의 데이터 (input 의 value)가 서버로 제출될때 해당 데이터가 인코딩되는 방법을 명시함.  
 
=> enctype="multipart/form-data" : 화일 upload 를 가능하게 해줌 
   ** multipart/form-data는 파일업로드가 있는 입력양식요소에 사용되는 enctype 속성의 값중 하나이고, 
       multipart는 폼데이터가 여러 부분으로 나뉘어 서버로 전송되는 것을 의미
       이 폼이 제출될 때 이 형식을 서버에 알려주며, 
       multipart/form-data로 지정이 되어 있어야 서버에서 정상적으로 데이터를 처리할 수 있다.     
-->
	<!-- 	<form action="join" method="post"> -->
	<form action="join" method="post" enctype="multipart/form-data" id="myForm">
		<table border="1">
			<tr height="40">
				<th bgcolor="aqua">ID</th>
				<td>
					<input type="text" name="id" id="id"
					placeholder="영어+숫자, 10글자 이내" size="20" />
					<button type="button" id="idDup"
						onClick="idDupCheck()">중복 확인</button>
					<span id="iMessage" class="eMessage"></span>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Password</th>
				<td>
					<input type="password" name="password" id="password"
					placeholder="영어+슷자+특수문자" size="20" />
					<span id="pMessage" class="eMessage"></span>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Password Check</th>
				<td>
					<input type="password" name="password2" id="password2"
					placeholder="패스워드 확인" size="20" />
					<span id="p2Message" class="eMessage"></span>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Name</th>
				<td>
					<input type="text" name="name" placeholder="한글 또는 영어"
					size="20" id="name" />
					<span id="nMessage" class="eMessage"></span>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Age</th>
				<td>
					<input type="text" name="age" id="age" placeholder="숫자입력"
					size="20" />
					<span id="aMessage" class="eMessage"></span>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Jno</th>
				<td><select name="jno">
						<option value="1">1조 (119조)</option>
						<option value="2">2조 (여우조)</option>
						<option value="3">3조 (i4조)</option>
						<option value="4">4조 (최고조)</option>
						<option value="5">5조 (오조)</option>
						<option value="7">7조 (관리팀)</option>
				</select></td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Info</th>
				<td><input type="text" name="info" placeholder="자기소개 & 희망사항"
					size="20" /></td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Point</th>
				<td>
					<input type="text" name="point" id="point" placeholder="실수입력"
					size="20" />
					<span id="oMessage" class="eMessage"></span>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Birthday</th>
				<td>
					<input type="date" name="birthday" id="birthday" size="20" />
					<span id="bMessage" class="eMessage"></span>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Rid</th>
				<td><input type="text" name="rid" placeholder="추천인" size="20" />
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="aqua">Image</th>
				<td><img src="" class="select_img"><br> <input
					type="file" name="uploadfilef" id="uploadfilef" size="20" /></td>
			</tr>
			<script>
				// 해당 파일의 서버상의 경로를 src로 지정하는것으로는 클라이언트 영역에서 이미지는 표시될수 없기 때문에
				// 이를 해결하기 위해 FileReader이라는 Web API를 사용
				// => 이 를 통해 url data를 얻을 수 있음.
				//    ( https://developer.mozilla.org/ko/docs/Web/API/FileReader)
				// ** FileReader
				// => 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여,
				//    읽을 파일을 가리키는File 혹은 Blob 객체를 이용해 파일의 내용을(혹은 raw data버퍼로) 읽고 
				//    사용자의 컴퓨터에 저장하는 것을 가능하게 해줌.   
				// => FileReader.readAsDataURL()
				//     지정된 Blob의 내용 읽기를 시작하고, 완료되면 result 속성에 파일 데이터를 나타내는 data: URL이 포함됨.
				// => FileReader.onload 이벤트의 핸들러.
				//    읽기 동작이 성공적으로 완료 되었을 때마다 발생.
				// => e.target : 이벤트를 유발시킨 DOM 객체
				// => type="file" 은 복수개의 파일을 업로드할수 있도록 설계됨
				//    그러므로 files[] 배열 형태의 속성을 가짐

				document.getElementById('uploadfilef').onchange = function(e) {
					//$('#uploadfilef').change(function(){
					if (this.files && this.files[0]) {
						let reader = new FileReader;
						reader.readAsDataURL(this.files[0]);
						reader.onload = function(e) {
							$(".select_img").attr("src", e.target.result)
									.width(70).height(90);
						} // onload_function
					} // if   
				}; //change  -> }); JQ 사용시
			</script>
			<tr height="40">
				<td colspan="2" style="text-align: center;">
					<input type="submit" value="가입" id="submitTag"
						onClick="return inCheck()" disabled/> &nbsp;&nbsp;
					<input type="reset" value="취소" />&nbsp;&nbsp;
					<input type="button" value="rsJoin" onclick="rsJoin()" />
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	</c:if>
	<!-- 	<a href="home">Home</a>&nbsp;&nbsp; -->
	<a href="/home">Home</a>&nbsp;&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp;&nbsp;
</body>
</html>