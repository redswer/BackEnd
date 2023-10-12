<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Hello JSP **</title>
</head>
<body>
	<h2>** Hello JSP **</h2>
	<h3>안녕하세요</h3>
	<h3>=> Java Code</h3>
	<pre>
	1) Scriptlet : 자바코드
	2) Expression : 표현식 (출력문)
	3) Declaration : 선언부 (메서드 등)
	</pre>

	<%! // Declaration : 선언부 
	public int multiply(int a, int b) {
		return a * b;
	}

	String name = "홍길동";
	int i = 100;
	int j = 200;%><br>

	multiply(4,5) => <%=multiply(4, 5)%><br>
	변수 출력: i = <%=i%>, j = <%=j%>, name = <%=name %><br>
	연산 적용: i+j = <%=i+j %><br>
	
	
	<% 
	int result = multiply(i,j);
	name = "Korea";
	%><br>
	
	** Script : 자바 코드<br>
	result = <%=result %><br>
	name = <%=name %>
	
</body>
</html>