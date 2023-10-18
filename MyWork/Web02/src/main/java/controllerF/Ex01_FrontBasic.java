package controllerF;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

//** FrontController 패턴 1.
//=> 대표 컨트롤러 1개만 서블릿으로 작성
// 나머지 컨트롤러는 일반 클래스로 작성
//=> 모든 요청을 이 대표컨트롤러(FrontController) 가 받도록 함.

//=> 요청에 대한 서비스를 if문으로 서블릿내에서 모두 처리
// 코드가독성, 모듈의 재사용성 떨어짐 
//=> Factory 패턴 적용
// 각각의 서비스를 일반클래스(컨트롤러)로 작성 Factory로부터 제공받음

//@WebServlet(urlPatterns = { "*.do" })
// => .do 가 붙어있는 요청은 모두 이 컨트롤러로 들어옴
// => web.xml 방식으로도 처리 가능
public class Ex01_FrontBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex01_FrontBasic() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청 분석
		// => uri 또는 url 분석 (요청명 확인)
		
		request.setCharacterEncoding("UTF-8");
		// => 한글처리

		String uri = request.getRequestURI();
		// uri : Web02/~~.do
		// url : http://localhost:8080/Web02/~~

		uri = uri.substring(uri.lastIndexOf("/"));
		// => uri 에서 '/' 부터 끝까지

		// ** 콘솔로 확인
		System.out.println("URL => " + request.getRequestURL());
		System.out.println("URI => " + request.getRequestURI());
		System.out.println("uri => " + uri);

		// 2. 해당 서비스 실행
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		
		if ("/mlist.do".equals(uri)) {
			request.setAttribute("banana", service.selectList());
			uri = "member/memberList.jsp";
			
		} else if ("/mdetail.do".equals(uri)) {
			dto.setId((String) request.getSession().getAttribute("loginID"));
			request.setAttribute("apple", service.selectOne(dto));
			uri = "member/memberDetail.jsp";
			
		} else {
			request.setAttribute("message", "요청사항 없음");
		}

		// 3. 결과처리 (View)
		request.getRequestDispatcher(uri).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
