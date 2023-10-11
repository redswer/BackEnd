package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** PageFlow 실습
//=> testForm: servletTestForm/flow02_TestForm.jsp

@WebServlet("/flow02")
public class Ex01_Flow02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex01_Flow02() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청(request) 분석
		// => uri, Forward or Redirect 확인
		String uri = "";

		// 2. Forward or Redirect
		String page = request.getParameter("page");
		String send = request.getParameter("send");

		switch (page) {
		case "1":
			uri = "helloS";
			break;
		case "2":
			uri = "lifecycle";
			break;
		case "3":
			uri = "servletTestForm/form03_Check.jsp";
			break;
		case "4":
			uri = "servletTestForm/form04_Select.jsp";
			break;
		}

//		if (send.equals("f")) {
//			request.getRequestDispatcher(uri).forward(request, response);
//		} else {
//			response.sendRedirect(uri);
//		}
		// => request.getParameter("send") 의 값이 없는 경우 NullPointExeception 발생

		if ("f".equals(send)) {
			request.getRequestDispatcher(uri).forward(request, response);
		} else {
			response.sendRedirect(uri);
		}
		// => NullPointExeception 을 방지하기 위해 "f" 와 send 의 순서를 바꿔줌
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
