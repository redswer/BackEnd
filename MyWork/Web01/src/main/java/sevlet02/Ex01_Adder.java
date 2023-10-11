package sevlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDTO;
import mvcTest.StudentService;

@WebServlet("/adder")
public class Ex01_Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex01_Adder() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석
		// => request Parameter 처리
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		// 2) Service 처리
		// 3) 결과( View ) 처리
		// => 한글처리, 출력객체 생성 & reponse 에 담기
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();	
		out.printf("<h3>%d + %d = %d</h3>", num1, num2, (num1 + num2));
	}
}
