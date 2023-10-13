<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** EL 기본사항 **</title>
</head>
<body>
	<h2>** EL 기본사항 **</h2>
	<%String name = "홍길동";%>
	<pre>
=> EL: Expression Language , 표현언어
=> 편리한 값(Value) 의 출력과 사용 

1. 값(변수의 값) 의 출력 비교
=> Java 표현식 : <%="Java 표현식 => " + name%>
=> Java 의 out 객체 : <%out.print("out 객체 => " + name);%>
=> EL 출력 (\${""}): ${"Hello EL, 표현 언어"}
=> El 로 Java 변수 출력 (\${"Java 변수" + name}) : 500 Error
   -> EL 내부에서 Java 변수는 사용 불가능
   -> EL은 주로 JSTL 과 병행하여 사용됨 

	<hr><b>
2. EL Test
** EL 자료형 **

정수형 : \${10} => ${10}
실수형 : \${10.123} => ${10.123}
문자형 : \${"안녕하세요"} => ${"안녕하세요"}
논리형 : \${true} => ${true}
null : \${null} => ${null}
<hr width="50%" align="left">
** EL 연산 **
=> 산술연산 (사칙연산)

\${5 + 2} = ${5 + 2}
\${5 - 2} = ${5 - 2}
\${5 * 2} = ${5 * 2}
\${5 / 2} = ${5 / 2}
\${5 % 2} = ${5 % 2}
<hr width="25%" align="left">
=> 관계 연산
-> gt: greater than / lt: less than
-> ge: greater equal / le: less equal
-> eq: equal, == / ne: not equal, !=

\${5 gt 2} : 5 > 2 => ${5 gt 2}
\${5 lt 2} : 5 < 2 => ${5 lt 2}
\${5 ge 2} : 5 >= 2 => ${5 ge 2}
\${5 le 2} : 5 <= 2 => ${5 le 2}
\${5 eq 2} : 5 == 2 => ${5 eq 2}
<%--
\${5 ne 2} : 5 != 2 => ${5 ne 2}
  -> 에디터 에서는 오류이지만 실행은 잘됨 --%>
<hr width="25%" align="left">
=> 논리(집합) 연산 : && , ||

\${5 > 2 && 10 > 20} => ${5 > 2 && 10 > 20}
\${5 > 2 || 10 > 20} => ${5 > 2 || 10 > 20}
<hr width="25%" align="left">
=> 조건(삼항) 식

\${5 > 2 ? 5 : 2} => ${5 > 2 ? 5 : 2}
\${5 > 2 ? '오' : '이'} => ${5 > 2 ? '오' : '이'}

	<hr>
3. 기타
** Java 변수
=> Java 표현식 : <%=name%>
=> \${name} : ${name}
   -> 자바변수는 출력하지 않음, JSTL로 정의한 변수는 출력
   -> name 의 값이 없음을 확인
   
 \${empty name} : ${empty name}
<!--
	=> empty : 검사할 객체가 비어있는지 확인 
        비어있으면 true 
        list, map 타입의 객체가 값이 있는지 없는지 구분해줌  
    => EL 에 자바변수는 직접 값을 전달하지 못함
     (jsp에서 자바코드가 완전 분리됨을 목표로 하기때문에 자바변수를 사용할 필요는 없으므로)  
    => EL 에 변수명이 오면 JSTL로 정의한 변수 또는 속성(Attribute) 의 이름으로 인식함.              
-->
<hr width="50%" align="left">
** request 객체의 Parameter 처리: 매우편리
=> request 객체의 Parameter를 전달하는 el의 내부객체 제공 : param
=> 퀴리스트링으로 id 지정 전.후 Test : ~/Web01/jsp04_el/ex01_elStart.jsp?id=banana

\${empty param.id} : ${empty param.id}
\${param.id} : ${param.id}
\${param["id"]} : ${param["id"]}
Java 표현식과 비교 : <%=request.getParameter("id")%>
<hr width="50%" align="left">
** getAttribute 처리 
=> ex02_~~~~ 에서 만나요 ~~~

	</b>
	</pre>
</body>
</html>