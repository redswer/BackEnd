package myDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//*** Spring MVC2_ver01
//=> MyDispatcherServlet (FrontController 역할)
//HandlerMapping, ViewResolver 를 활용해서
//요청분석, Service, View 를 처리

//@WebServlet(urlPatterns={"*.do"})
//=> 모든 요청 처리는 web.xml 에서
public class MyDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ** 전역변수 정의
	private MyHandlerMapping hmappings;
	private MyViewResolver vresolver;

	// ** 생성자에서 멤버 초기화
	public MyDispatcher() {
		super();
		hmappings = MyHandlerMapping.getInstance();
		vresolver = new MyViewResolver();
		vresolver.setPrefix("/WEB-INF/views/");
		vresolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청 분석 & 한글 처리
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String mappingName = uri.substring(uri.lastIndexOf("/"));
		uri = "home"; // => mappingName 추출후 viewName 용도로 사용

		// 2. 해당 서비스 실행
		// => MyHandlerMapping 에 요청, 해당 서비스 컨트롤러의 인스턴스 제공
		MyController controller = hmappings.getController(mappingName);
		// http://localhost:8080/green/mlist -> /mlist

		if (controller != null) {
			uri = controller.handleRequest(request, response);
		} else {
			request.setAttribute("message", "없는 요청");
		}

		// 3. View 처리
		// => viewResolver 를 활용하여 viewName 을 완성
		uri = vresolver.getViewName(uri);
		request.getRequestDispatcher(uri).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
