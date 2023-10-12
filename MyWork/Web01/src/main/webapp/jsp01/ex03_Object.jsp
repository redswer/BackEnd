<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Jsp Object **</title>
</head>
<body>
	<h2>** Jsp Object **</h2>
	<pre>
=> Web 애플리케이션 기본 객체(implicit object)
=> JSP에서 별도 선언 없이 사용 가능
=> request, response, out, session, 
   pageContext, application 등 9종류
	</pre>
	<hr>

	<h3>1. Request</h3>
	<pre>
* ContextPath => <%=request.getContextPath()%>
* RealPath => <%=request.getRealPath("/")%>
* RequestURI => <%=request.getRequestURI()%>
	</pre>

	<h3>2. Session</h3>
	<pre>
* Session_ID => <%=session.getId()%>
	</pre>
	
	<h3>3. Out</h3>
	<pre>
* out 출력 => <%out.print("out 객체(out.print)로 출력");%>
	</pre>
	
	<h3>4. PageContext</h3>
	<pre>
=> JSP 페이지에 대한 정보를 저장한다.
=> 기본 객체를 return 하는 메서드를 제공.
   -> request 객체와 메서드가 return하는 객체와 동일성 비교
<%
HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
%>
* 비교 결과 : <%=request == req%>

* pageContext 가 제공하는 out 객체로 출력 => <%pageContext.getOut().print("pageContext 가 제공하는 out 객체로 출력");%>
	</pre>
	
	<h3>5. Application</h3>
	<pre>
* 서버 정보 => <%=application.getServerInfo()%>
* Servlet 메이저 버전 => <%=application.getMajorVersion()%>
* Servlet 마이너 버전 => <%=application.getMinorVersion()%>
* RealPath 1 => <%=application.getRealPath("")%>
	-> "" 사용 시에는 현재 프로젝트에서 실행 중인 RealPath return
* RealPath 2 => <%=application.getRealPath("/jsp01")%>
	-> 지정한 경로의 RealPath (HDD 상의 소스 위치가 아님에 주의)
	</pre>
</body>
</html>