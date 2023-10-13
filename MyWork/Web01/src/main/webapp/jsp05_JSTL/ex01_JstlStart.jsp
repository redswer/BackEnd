<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL Start **</title>
</head>
<body>
	<pre>
** JSTL Start **
=> Jstl Library 를 정의 (현재문서_Page 가 인식할 수 있도록)
   디렉티브 taglib (tag library)에 uri=".." prefix=".."
   <hr>
1. 출력 : out Tag
=> Java 의 out객체, 표현식 역할, EL을 대신할 수 있음
<b>
<c:out value="Hello JSTL, 안녕 제이에스티엘" />
</b>
<hr width="50%" align="left">
2. 변수 정의
=> set
<c:set value="홍길동" var="name"/>
<c:set value="22" var="age"/>
var: 변수명, value: 변수값

<hr width="50%" align="left">
3. 변수 출력 (out_Tag, EL)

3-1) JSTL 의 out_Tag

<b>name : out 태그의 value = "\${name}" => <c:out value="${name}"/></b>
<b>age : out 태그의 value = "\${age}" => <c:out value="${age}"/></b>
<hr width="25%" align="left">
3-2) EL

<b>name : \${name} => ${name}</b>
<b>age : \${age} => ${age}</b>
<b>age * 100 : \${age * 100} => ${age * 100}</b>
<hr width="25%" align="left">
3-3) Java 와 JSTL 호환 test
<%-- * name = <%=name%> --%>
<b>호환되지 않음</b>

<hr width="50%" align="left">
4. 연산 적용
<c:set value="${age + age}" var="add"/>
<b>add : age + age => \${add} = ${add}</b>
<c:set value="${name==age}" var="bool" />
<b>bool : name == age => \${bool} = ${bool}</b>
<c:set value="${age>add ? age:add}" var="max" />
<b>max : (age > add ? age : add) => \${max} = ${max}</b>

<hr width="50%" align="left">
5. 변수 삭제
<c:remove var="add"/>
<b>remove 태그의 var = "add"</b>

<b>\${add} => ${add}</b>

<b>\${empty add} => ${empty add}</b>

<c:remove var="password"/>
<b>remove 태그의 var = "password"</b>
=> 정의하지 않은 변수 삭제해도 오류 발생하지 않음

<hr width="50%" align="left">
6. 우선순위
=> jstl 변수 와 Attribute (pageScope) 
=> 동일하게 Page에 정의된 경우에는 나중에 정의된 값이 우선 적용됨
   page(set변수, attribute 중 나중에 정의된 값 우선) 
   -> request -> session -> application 

6-1) name 정의 순서 : set -> pageContext.setAttribute   
<%pageContext.setAttribute("name", "그린컴"); %>
<b>\${name} => ${name}</b>
=> 나중에 생성한 name 이 출력됨
<hr width="25%" align="left">
6-2) set name 재정의
<c:set value="new_홍길동" var="name"/>
<b>\${name} => ${name}</b>
=> 마지막에 정의한 값으로 적용됨
	</pre>
</body>
</html>