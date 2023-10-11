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

@WebServlet("/select")
public class Ex04_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_Select() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석
		// => request Parameter 처리
		request.setCharacterEncoding("UTF-8");
		
		String job = request.getParameter("job");
		String interest = request.getParameter("interest");

		// 2) Service 처리
		// 3) 결과( View ) 처리
		// => 한글처리, 출력객체 생성 & reponse 에 담기
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();	
		out.printf("<h3>직업 : ");
		if(job.equals("")) {
			out.print("직업을 선택하지 않았습니다.");
		} else {
			out.print(job);
		}
		out.print("</h3>");
		out.printf("<h3>관심분야 : " + interest + "</h3>");
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 선택하기</a></h2><br>");
	}
}
