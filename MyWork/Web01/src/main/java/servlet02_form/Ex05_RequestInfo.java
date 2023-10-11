package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestinfo")
public class Ex05_RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex05_RequestInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ** 기본 화면 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<h2> ** Request Info ** </h2>");
		out.print("<h3> => 주요 메서드 </h3>");
		out.print("<h3> 1) Request Header 의 names & values </h3>");
		out.print("<h3> 2) ContextPath: 웹애플리케이션의 최상위 경로 </h3>");
		out.print("<h3> 3) RealPath: 웹애플리케이션의 실행위치</h3>");
		out.print("<h3> 4) 기타등등 </h3>");
		out.print("<h3> => Console 창에서 확인하세요 ~~~</h3>");
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");

		// ** console 출력
		System.out.println("** Request Info **");
		System.out.println("1) Request Header 의 names & values");

		Enumeration<String> hNames = request.getHeaderNames();
		// => request 에 대한 header name 들을 반환

		while (hNames.hasMoreElements()) {
			String hName = hNames.nextElement();
			System.out.printf("* %s = %s \n", hName, request.getHeader(hName));
		}

		System.out.println("");
		System.out.println("2) ContextPath: 웹애플리케이션의 최상위 경로");
		System.out.println(request.getContextPath());

		System.out.println("");
		System.out.println("3) RealPath: 웹애플리케이션의 실행위치");
		System.out.println(request.getRealPath("/"));

		System.out.println("");
		System.out.println("4) 기타등등");
		System.out.println("4-1) RemoteAddress");
		System.out.println(request.getRemoteAddr());
		System.out.println("");
		System.out.println("4-2) Method");
		System.out.println(request.getMethod());
		System.out.println("");
		System.out.println("4-3) RequestURL");
		System.out.println(request.getRequestURL());
		System.out.println("");
		System.out.println("4-4) RequestURI");
		System.out.println(request.getRequestURI());
		System.out.println("");
		System.out.println("4-5) ServerName");
		System.out.println(request.getServerName());
		System.out.println("");
		System.out.println("4-6) ServerPort");
		System.out.println(request.getServerPort());
		System.out.println("");
		System.out.println("4-7) ServletPath");
		System.out.println(request.getServletPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class