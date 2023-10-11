package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** getAttribute
//=> 전달된 Attribute들 확인

@WebServlet("/02get")
public class Ex03_02getAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_02getAttribute() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. getAttribute
		// => setAttribute 에 보관된 값 꺼내기

		// 1-1) request
		String rid = (String) request.getAttribute("rid");
		String rname = (String) request.getAttribute("rname");
		// => getAttribute 는 object 타입을 리턴하기 때문에 string 으로 변경

		// int rage = (Integer) request.getAttribute("rage");
		String rage = (String) request.getAttribute("rage");
		// => Integer 타입으로 변환하면 rage 의 값이 없는 경우(null 인 경우) 오류
		// => 따라서 간편한 test 를 위해 String 으로 처리

		// 1-2) sesseion
		String sid = (String) request.getSession().getAttribute("sid");
		String sname = (String) request.getSession().getAttribute("sname");
		String sage = (String) request.getSession().getAttribute("sage");
//		--------------------------
		// 2. View (출력)
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<h2>** 1) Parameter 값 확인 **</h2>");
		out.print("<h3>=> request객체에 담겨있는 Parameter값이 유지되고 있는지 확인</h3>");
		out.print("<h3> I D  : " + request.getParameter("id") + "</h3>");
		out.print("<h3> Name : " + request.getParameter("name") + "</h3>");
		out.print("<h3> Age  : " + request.getParameter("age") + "</h3>");

		out.print("<h2>** 2) request.getAttribute 값 확인 **</h2>");
		out.print("<h3> rI D : " + rid + "</h3>");
		out.print("<h3> rName: " + rname + "</h3>");
		out.print("<h3> rAge : " + rage + "</h3>");

		out.print("<h2>** 3) session.getAttribute 값 확인 **</h2>");
		out.print("<h3> sI D : " + sid + "</h3>");
		out.print("<h3> sName: " + sname + "</h3>");
		out.print("<h3> sAge : " + sage + "</h3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
