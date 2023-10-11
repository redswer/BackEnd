package servlet02_form;

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

@WebServlet("/radio")
public class Ex02_Radio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_Radio() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석
		// => request Parameter 처리
		request.setCharacterEncoding("UTF-8");
		
		String gender = request.getParameter("gender");
		String mailcheck = request.getParameter("mailcheck").equals("Yes") ? "수신동의" : "수신거절";
		String content = request.getParameter("content");

		// 2) Service 처리
		// 3) 결과( View ) 처리
		// => 한글처리, 출력객체 생성 & reponse 에 담기
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();	
		out.printf("<h2>신규회원</h2>");
		out.printf("<h3>성별 : " + gender + "</h3>");
		out.printf("<h3>메일수신 여부 : " + mailcheck + "</h3>");
		out.printf("<h3>가입인사 : " + content + "</h3>");
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");
	}
}
