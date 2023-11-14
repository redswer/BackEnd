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