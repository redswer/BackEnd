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

@WebServlet("/check")
public class Ex03_CheckBox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_CheckBox() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석
		// => request Parameter 처리
		request.setCharacterEncoding("UTF-8");

		String[] gift = request.getParameterValues("gift");
		// => 여러 개를 선택할 경우 배열에 담아 getParameterValues 를 사용

		// 2) Service 처리
		// 3) 결과( View ) 처리
		// => 한글처리, 출력객체 생성 & reponse 에 담기
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.printf("<h3>좋아하는 것 : ");
//		if (gift == null) {
//			out.print("관심분야 없음");
//		} else {
//			for (int i = 0; i < gift.length; i++) {
//				out.print(gift[i]);
//
//				if (i < gift.length - 1) {
//					out.print(", ");
//				}
//			}
//		}
		if(gift != null && gift.length > 0) {
			for(String s:gift) {
				out.print(s + "<br>");
			}
		} else {
			out.print("선택항목 없음");
		}
		out.printf("</h3>");
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 선택하기</a></h2><br>");
	}
}
