<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Parameter 활용 **</title>
</head>
<body>
	<pre>
<h3>** Parameter 활용 **</h3>
=> 동질성 비교, null 확인
1. 동질성 비교

* I D : <b>\${param.id} => ${param.id}</b>
* P W : <b>\${param.pw} => ${param.pw}</b>
<b>
\${param.id == 'admin'} => ${param.id == 'admin'}
\${param.pw == '12345'} => ${param.pw == '12345'}
</b>
<hr width=50% align="left">
2. null 확인 : empty, ==
=> 쿼리 스트링에 ?id=admin&pw=12345 추가하고 test
=> 쿼리 스트링에 ?id=admin&pw= 추가하고 test

2-1) empty : 해당하는 Parameter가 존재하지않거나, 존재하지만 값이 없는 경우 모두 true 
<b>
\${empty param.id} => ${empty param.id}
\${empty param.pw} => ${empty param.pw}
</b>
2-2) == null : 해당하는 Parameter가 존재하지않으면 true, 존재하지만 값이 없는 경우에는 false
<b>
\${param.id == null} => ${param.id == null}
\${param.pw == null} => ${param.pw == null}
</b>
<hr width=50% align="left">
3. pageContext
=> JSP 페이지에 대한 정보를 저장한다.
=> 기본 객체를 return 하는 메서드를 제공.
* 요청 URL: ${pageContext.request.requestURL}
* 요청 URI: ${pageContext.request.requestURI}
	</pre>
</body>
</html>