<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Jsp Page Flow **</title>
</head>
<body>
	<h2>** Jsp Page Flow</h2>
	<hr>

	<h3>1. Forward</h3>
	<pre>
=> jsp Action Tag 를 활용한 이동
	</pre>
	<%-- <jsp:forward page="ex01_HelloJsp.jsp" /> --%>

	<h3>2. Include</h3>
	<pre>
* JSP Action Tag
  -> Jsp 문서의 완성된 웹페이지가 포함됨, 변수 공유 불가능 (코드 호환 x)
	</pre>
	<jsp:include page="ex01_HelloJsp.jsp" />
	<hr align=left width=50%>
	<pre>
* Directive Include
  -> Jsp 문서의 소스코드가 포함됨, 변수 공유 가능 (코드 호환 o)
	</pre>
	<%@include file="ex01_HelloJsp.jsp"%>
</body>
</html>