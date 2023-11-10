// ** Ajax Rest API Test **

// 1) reLogin

// 1-1) form 출력

function rsLoginf() {
	let resultHTML = `
		<table>
			<tr height="40">
				<td bgcolor="aqua"><label for="id">ID</label></td>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<tr height="40">
				<td bgcolor="aqua"><label for="password">Password</label></td>
				<td><input type="password" id="password" name="password"></td>
			</tr>
			<tr height="30">
        		<td colspan=2>
        			<span class="textlink" onclick="rsLogin()">rsLogin</span>&nbsp;&nbsp;
        			<span class="textlink" onclick="rsLoginJJ()">rsLoginjj</span>&nbsp;&nbsp;
        			<span class="textlink" onclick="axiLoginJJ()">axiLoginjj</span>&nbsp;&nbsp;
         			<input type="reset" value="취소">
         		</td>
			</tr>
		</table>
	`;
	
	document.getElementById('resultArea1').innerHTML = resultHTML;
}

// -------------------------------
// 1-2) login 기능 Service 요청 처리
// Ajax 요청, fetch 처리
// => @RestController, 계층적 uri 적용, Post 요청

//=> JSON의 파일 확장자는 .json
//=> 주요 메서드
//   - JSON.stringify() : JavaScript 값이나 객체를 JSON 문자열로 변환.
//   - JSON.parse() :  JSON 문자열을 구문 분석하여 JavaScript 값이나 객체를 생성함.

function rsLogin() {
	let url = "/rest/rslogin";
	
	fetch(url, {
		method:'post',
		body:JSON.stringify({id:document.getElementById('id').value,
							password:document.getElementById('password').value}),
		headers:{'Content-Type':'application/json'}
		// => POST 요청에서는 반드시 headers 형식 작성 
		//    (JSON 포맷을 사용함을 알려줘야함)
		
	}).then(response => {
		// ** then 1 단계
	    // => status 확인 -> Error catch 블럭으로 또는 Response Body-reading Data return
	    // => Response Body의 Data-reading & return.
	
		if (!response.ok) {
			throw new Error(response.status);
		}
		// => Error 임을 인지시켜 catch 블럭으로 
     	//   - fetch는 네트워크 장애가 발생한 경우에만 promise를 거부(reject -> catch 블럭으로) 하므로,
     	//     .then절(1단계) 에서 수동으로 HTTP 에러를 처리함.
     	//     그러나 axios는 상태코드가 2xx의 범위를 넘어가면 거부(reject)함.
     	
     	return response.text();
     	// => 서버에서 text 형식으로 보냈으므로 text() 메서드 사용
     	
	}).then(responseData => {
	   	// ** then 2 단계
       	// => 1단계에서 return 한 Data 처리
       	
       	alert(`** responseData => ${responseData}`);
       	// => 밑에서 reload() 호출 구문을 사용하면 이전에 작성한 console message는 출력 안되므로 alert 사용함. 
       	
       	location.reload();
       	// => 화면 새로고침
	
	}).catch(err => {
		console.error(`** Error => ${err.message}`);
		
		if (err.message == 502) {
			alert('id 또는 password 오류');
		} else {
			alert('system 오류');
		}
	});
}

// ---------------------------
// 1-3) JSON -> JSON

function rsLoginJJ() {
	let url = "/rest/rsloginjj";
	
	fetch(url, {
		method:'post',
		body:JSON.stringify({id:document.getElementById('id').value,
							password:document.getElementById('password').value}),
		headers:{'Content-Type':'application/json'}
		
	}).then(response => {
		if (!response.ok) {
			throw new Error(response.status);
		}
		
     	return response.json();
     	// => 서버에서 JSON 형식으로 보냈으므로 json() 메서드 사용 
     	
	}).then(responseData => {
       	alert(`** responseData => id=${responseData.id}, name=${responseData.username}`);
       	location.reload();
       	
	}).catch(err => {
		console.error(`** Error => ${err.message}`);
		
		if (err.message == 502) {
			alert('id 또는 password 오류');
		} else {
			alert('system 오류');
		}
	});
}

// ==================================================
// 2) Axios Login
// => JSON -> JSON
// => 라이브러리 추가 필요함 (CDN 으로)

function axiLoginJJ() {
	let url = "/rest/rsloginjj";
	
	axios({ url: url,
			method: 'Post',
			headers: { 'Content-Type': 'application/json'},
			data: { id: document.getElementById('id').value,
					password: document.getElementById('password').value
			}
	}).then(response => {
		alert(`** response.data => ${response.data}`);
		alert(`** response => id: ${response.data.id}, name: ${response.data.username}`);
		
		location.reload();
		
	}).catch(err => {
		console.error(`** err.response, status, message => ${err.response}, ${err.response.status}, ${err.message}`);
		
		if (err.response.status == 502) {
			alert('id 또는 password 오류');
		} else {
			alert('system 오류');
		}
	});
}
