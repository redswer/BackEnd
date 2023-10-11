package servlet03_flow;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/01set")
public class Ex03_01setAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_01setAttribute() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Request 처리
		// => 한글처리(post 요청시에만 필요 / get 에서는 생략 가능), Parameter 처리
		// => form 태그 없이 쿼리스트링으로 Test
		// -> .../01set?id=banana&name=홍길동&age=22

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		// => getParameter 는 string 을 리턴하므로 int 로 변환해야 하지만
		// => 원활한 test 를 위해 string 으로 처리

		System.out.println("** setAttribute Test **");
		System.out.printf("Parameter : id=%s, name=%s, age=%s\n", id, name, age);
//		------------------------------
		// 2. SetAttribute 로 보관
		// => 보관 가능한 Scope : page < request < session < application

		// 2-1) request
		// => request.setAttribute(변수명, 값)
		request.setAttribute("rid", id);
		request.setAttribute("rname", name);
		request.setAttribute("rage", age);

		// 2-2) session
		// => HttpSession session = request.getSession();
		//		session.setAttribute(,);
		request.getSession().setAttribute("sid", id);
		request.getSession().setAttribute("sname", name);
		request.getSession().setAttribute("sage", age);

//		------------------------------
		// 3. 이동 후 getAttribute
		// => Forward / Redirect
		
		// 3-1) Forward
		String uri = "02get";
//		request.getRequestDispatcher(uri).forward(request, response);
		// => 쿼리스트링 요청(.../01set?id=banana&name=홍길동&age=22)하면 모두 변경됨
		
		// 3-2) Redirect
		response.sendRedirect(uri);
		// => 쿼리스트링 요청(.../01set?id=banana&name=홍길동&age=22)하면 session 만 변경됨
		
		// => session 에 보관한 값은 invalidate 하기 전까지 남아있음을 확안
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
