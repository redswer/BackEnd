<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Board CriList **</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<script>
	//1. 검색조건 입력 후 버튼클릭
	// => 입력된 값들을 서버로 전송요청: location
	function searchDB() {
	   self.location='bcriList'
	            +'${pageMaker.makeQuery(1)}'
	            +'&searchType='+document.getElementById('searchType').value
	            +'&keyword='+document.getElementById('keyword').value;
	} //searchDB() 
	
	// => 검색조건 입력 후 첫 Page 요청
	//    이때는 서버에 searchType, keyword 가 전달되기 이전이므로 
	//     searchType, keyword 가 없는 makeQuery 메서드사용
	// => self.location="bcrilist?currPage=?????" : 해당 요청을 서버로 전달    
	      
	// *** JS 코드 내부에서 el Tag 사용시 주의사항
	// => JS 코드의 스트링 내에서 사용한 el Tag 는 JSP 가 처리해주므로   
	//    사용가능 하지만, 이 스크립트가 외부 문서인 경우에는 처리해주지 않으므로 주의
	//    이 코드를 외부문서로 작성하면 "${pageMaker.makeQuery(1)}" 이 글자 그대로 적용되어 404 발생 
	      
	// ** self.location   
	// 1) location 객체 직접사용 Test : url로 이동, 히스토리에 기록됨
	// 2) location 객체의 메서드
	// => href, replace('...'), reload() 
	
// 2. searchType 을 '전체' 로 변경하면 keyword는 clear 
	function keywordClear(){
	   if ( document.getElementById('searchType').value=='all' )
	      document.getElementById('keyword').value='';   
	} 
</script>
</head>
<body>
	<h2>** Spring_Boot Board CriList **</h2>
	<hr>
	<div id="searchBar">
		<select name="searchType" id="searchType" onchange="keywordClear()">
      		<option value="all" ${pageMaker.cri.searchType==all ? 'selected' : ''}>전체</option>
     		<option value="title" ${pageMaker.cri.searchType=='title' ? 'selected' : ''}>Title</option>
     		<option value="content" ${pageMaker.cri.searchType=='content' ? 'selected' : ''}>Content</option>
      		<option value="id" ${pageMaker.cri.searchType=='id' ? 'selected' : ''}>ID(글쓴이)</option>
      		<option value="regdate" ${pageMaker.cri.searchType=='regdate' ? 'selected' : ''}>RegDate</option>
		</select>
	   	<input type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword}">
	   	<button id="searchBtn" onclick="searchDB()">Search</button>
	</div>
	<br>
	<hr>
	<table border="1" style="width: 90%;">
		<tr bgcolor="LimeGreen">
			<th>Seq</th>
			<th>Title</th>
			<th>ID</th>
			<th>Regdate</th>
			<th>조회수</th>

			<!-- 관리자 기능으로 추가 -->
			<c:if test="${sessionScope.loginID == 'admin'}">
				<th>Delete</th>
			</c:if>
		</tr>
		<c:if test="${!empty requestScope.banana}">
			<c:forEach var="m" items="${requestScope.banana}">
				<tr>
					<td>${m.seq}</td>

					<c:if test="${!empty sessionScope.loginID}">
						<td>
							<a href="bdetail?seq=${m.seq}">
								<c:if test="${m.indent > 0}">
									<c:forEach begin="1" end="${m.indent}" >
										<span>&nbsp;&nbsp;</span>
									</c:forEach>
									<span style="color:blue;">re..)</span>
								</c:if>
								${m.title}
							</a>
						</td>
					</c:if>
					<c:if test="${empty sessionScope.loginID}">
						<td>${m.title}</td>
					</c:if>

					<td>${m.id}</td>
					<td>${m.regdate}</td>
					<td>${m.cnt}</td>
					<c:if test="${sessionScope.loginID == 'admin'}">
						<td><a href="bdelete?seq=${m.seq}&root=${m.root}">삭제</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.banana}">
			<tr>
				<td colspan="5">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>
	<div>
		<!-- ** Cri Paging ** -->
		<!-- 1) FirstPage, Prev  -->
		<c:choose>
			<c:when test="${pageMaker.prev && pageMaker.spageNo > 1}">
				<!-- version 1 (paging) -->
				<%-- <a href="bcriList?currPage=1&rowsPerPage=5">FP</a>&nbsp;
				<a href="bcriList?currPage=${pageMaker.spageNo-1}&rowsPerPage=5">&LT;</a>&nbsp;&nbsp; --%>
				
				<!-- version 2 (paging + 검색) -->
				<a href="bcriList${pageMaker.searchQuery(1)}">FP</a>&nbsp;
				<a href="bcriList${pageMaker.searchQuery(pageMaker.spageNo-1)}">&LT;</a>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<font color="Gray">FP&nbsp;&LT;&nbsp;&nbsp;</font>
			</c:otherwise>
		</c:choose>
		
		<!-- 2) Display PageNo -->
		<c:forEach var="i" begin="${pageMaker.spageNo}" end="${pageMaker.epageNo}">
			<c:if test="${i == pageMaker.cri.currPage}">
				<font color="Orange" size="5"><b>${i}</b></font>&nbsp;
			</c:if>
			<c:if test="${i != pageMaker.cri.currPage}">
				<!-- <a href="bcriList?currPage=${i}&rowsPerPage=5">${i}</a>%nbps; -->
				<%-- <a href="bcriList${pageMaker.makeQuery(i)}">${i}</a>&nbsp; --%>
				<a href="bcriList${pageMaker.searchQuery(i)}">${i}</a>&nbsp;
			</c:if>
		</c:forEach>
	 	
		<!-- 3) Next, LastPage -->
		<c:choose>
			<c:when test="${pageMaker.next && pageMaker.epageNo > 0}">
			<%-- &nbsp;<a href="bcriList${pageMaker.makeQuery(pageMaker.epageNo+1)}">&GT;</a>
				&nbsp;<a href="bcriList${pageMaker.makeQuery(pageMaker.lastPageNo)}">LP</a> --%>
				&nbsp;<a href="bcriList${pageMaker.searchQuery(pageMaker.epageNo+1)}">&GT;</a>
				&nbsp;<a href="bcriList${pageMaker.searchQuery(pageMaker.lastPageNo)}">LP</a>
			</c:when>
			<c:otherwise>
				<font color="Gray">&nbsp;&GT;&nbsp;LP</font>
			</c:otherwise>
		</c:choose>
	</div>
	<hr>
	<br>
	<c:if test="${!empty sessionScope.loginID}">
		<a href="boardInsert">새 글 등록</a>
	</c:if>
	<hr>
	&nbsp;
	<a href="/home">Home</a>
</body>
</html>