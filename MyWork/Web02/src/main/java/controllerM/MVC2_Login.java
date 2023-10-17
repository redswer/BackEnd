package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

@WebServlet("/mlogin")
public class MVC2_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MVC2_Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청분석
		// => 한글, request 의 parameter

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		String uri = "index.jsp";

		dto.setId(id);
		dto = service.selectOne(dto);

		if (dto != null && dto.getPassword().equals(password)) {
			request.getSession().setAttribute("loginName", dto.getName());
			request.getSession().setAttribute("id", id);
		} else {
			request.setAttribute("message", "로그인 실패");
			uri = "member/loginForm.jsp";
		}		
		request.getRequestDispatcher(uri).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("** doPost 실행 **");
		doGet(request, response);
	}

}
