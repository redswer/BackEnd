"use strict";

// ** Ajax_Rest API (Axios Test) **

// 1. axMemberList 의 id 를 클릭하면 본인이 쓴 글 목록이 resultArea2 에 출력되도록
// => response 는 JSON 으로
// => RTestController, SQL 구문은 Mapper 인터페이스에 @ 로 작성

function idBList(id) {
	let url = "/rest/idblist/" + id;
	
	axios.get(url
	).then(response => {
		alert("** list 호출 성공 **");
		
		let list = response.data;
		console.log(list);
		console.log(list.length);
		
		let result = "";
		
		for (let b of list) {
			result += `<tr height="40">
							<td>${b.seq}</td> 
							<td>${b.title}</td>
							<td>${b.id}</td>
							<td>${b.content}</td>
							<td>${b.regdate}</td>
							<td>${b.cnt}</td>
						</tr>
			`;
		}
		
		document.getElementById('resultArea2').innerHTML = `
			<table border="1px" width="100%" style="text-align:center;">
				<tr height="40" bgcolor="honeydew">
					<th>seq</th>
					<th>title</th>
					<th>id</th>
					<th>content</th>
					<th>Regdate</th>
					<th>조회수</th>
				</tr>
				${result}
			</table>
		`;
		
	}).catch(err => {
		if (err.response.status == '502') {		
			alert("** response 실패 => " + err.response.data);
			document.getElementById('resultArea2').innerHTML = "";
		} else {
			alert("시스템 오류 => "+err.response.status);
		}
	});
}

// ===============================================
// ** JoDetail

// 1) showJoDetail
// => jno 에 mouseover 시 jno 의 detail 을 id 가 content 인 div 에 출력
// => request : axios, get, RTestController 에 jodetail 요청으로 
// => response : JoDTO 객체

function showJoDetail(e, jno) {

	// ** 이벤트 객체 활용
	// => 마우스 포인터 위치 확인
	//	- event 객체 (이벤트 핸들러의 첫 번째 매개변수) 가 제공
	// 	- e.pageX, e.pageY : 전체 Page 기준
	// 	- e.clientX, e.clientY : 보여지는 화면 기준 -> page scroll 시에 불편함
	console.log("e.pageX => "+e.pageX);
	console.log("e.pageY => "+e.pageY);
	console.log("e.clientX => "+e.clientX);
	console.log("e.clientY => "+e.clientY);
	
	let url = "/rest/jodetail?jno="+jno;
	
	axios.get(url
	).then(response => {
		// alert("** response 성공");
		document.getElementById('content').innerHTML = `
			<table>
				<tr>
					<th align="right">jno:</th>
					<td>${response.data.jno}</td>
				</tr>
				<tr>
					<th align="right">jname:</th>
					<td>${response.data.jname}</td>
				</tr>
				<tr>
					<th align="right">id:</th>
					<td>${response.data.id}</td>
				</tr>
				<tr>
					<th align="right">project:</th>
					<td>${response.data.project}</td>
				</tr>
				<tr>
					<th align="right">slogan:</th>
					<td>${response.data.slogan}</td>
				</tr>
			</table>
		`;

		document.getElementById('content').style.display = 'block';
		document.getElementById('content').style.left = e.pageX+"px";
		document.getElementById('content').style.top = e.pageY+"px";
	}).catch(err => {
		if (err.response.status == '502') {
			alert("** response 실패 => "+err.response.data);			
		} else {
			alert("** 시스템 오류 => "+err.response.status);
		}
	})
}

// -----------------------------
// 2) hideJoDetail
// => 화면에 표시되어 있는 content div 가 사라짐

function hideJoDetail() {
	document.getElementById('content').style.display = 'none';
	document.getElementById('content').innerHTML = "";
}