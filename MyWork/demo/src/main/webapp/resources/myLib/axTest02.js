'use strict';

// 1) rsJoin
// => Request: jQuery Ajax / Response: Page(MemberController 의 memberjoin 메서드)

// 1-1) rsJoin Form
function rsJoinf() {
	let url = "/member/memberJoin";

	$.ajax({
		type: 'Get',
		url: url,
		success: function (resultPage) {
			// => 서버에서 page 를 전송하면 page 가, data 를 전송하면 data 가 인자 값(resultPage)이 됨
			document.getElementById('resultArea1').innerHTML = resultPage;
		},
		error: function () {
			document.getElementById('resultArea1').innerHTML = "Ajax error";
		}
	});
}
// ---------------------------
// 1-2) rsJoin Service 요청
// => form의 Data 처리방법
//		- 직접 입력 : uploadfilef 를 처리할 수 없음 
//		- Form 의 serialize()
//			-> input Tag 의 name 과 id 가 같아야 함.   
//			-> 직렬화 : multipart 타입(file Type 등)은 전송되지 않고 제외시킴
//		- 객체화: 마찬가지로 uploadfilef 를 처리할 수 없음
// => 따라서 FormData 객체 활용
//      -> append 메서드 : uploadfilef 처리 불편
//      -> 생성자 매개변수 이용 : uploadfilef 포함 간편한 처리가능
// => 따라서 FormData 의 생성자 매개변수 이용

function rsJoin() {
	// 1. Data 준비
	// => JS 의 내장 객체인 FormData 에 담아서 전송
	let formData = new FormData(document.getElementById('myForm'));

	// 2. Ajax 요청
	$.ajax({
		type: 'Post',
		url: '/rest/rsjoin',
		data: formData,

		processData: false,
		contentType: false,
		//=> 다른 데이터 타입을 무시하고 formData 에 담겨있는 데이터를 전송하기 위해 둘 다 false 설정해야 함

		success: (resultData) => {
			// => 결과는 text 로 전달받음
			document.getElementById('resultArea1').innerHTML = resultData;
		},
		error: () => {
			document.getElementById('resultArea1').innerHTML = "Ajax error";
		}
	});

}