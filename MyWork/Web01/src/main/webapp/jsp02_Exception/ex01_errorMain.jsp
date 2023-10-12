<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%-- <%@ page errorPage="ex01_errorMessage.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Exception Main **</title>
</head>
<body>
		<pre>
	<h2>
** Exception Main **
=> 1) WebPage 별로
   -> WebPage 의 page 디렉티브에서 정의
   -> Error 종류에 무관하게 Page별로 처리
=> 2) 응답상태코드(404, 500 등): web.xml 
=> 3) Exception Type 별로: web.xml
   -> 2),3) web.xml에 설정하는 경우에는 프로젝트 전체에 적용
   
=> 4) 에러처리의 우선순위: 1) -> 3) -> 2)   
<hr>
1) NullPointerException : Exception Type
* Country: <%=request.getParameter("country").toUpperCase()%>
   => Parameter에 country 가 없으면 return null
   => NullPointerException -> 500 -> 현재 Page에서 대응
   => jsp 문서 상단의 page Directive 에서 errorPage 로 에러 페이지 설정 가능

2) NumberFormatException : 상태코드 500
* Number: <%=Integer.parseInt(request.getParameter("country"))%> 
	=> 쿼리스트링에 ?country=korea 를 주면 발생

3) ArithmeticException : Exception Type
   => by Zero
   123/0 = <%=123 / 0%> 
   => 쿼리스트링에 ?country=0 를 주면 발생
	</h2>
	</pre>
</body>
</html>