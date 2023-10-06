package servlet01;

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

@WebServlet("/sList01")
public class Ex02_MVC01List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_MVC01List() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ** MVC01 Student List 출력하기
		// => 요청 Service 처리
		// => 출력할 DataList 가져오기
		// => 출력 (출력할 내용 response 객체에 담기)
		// -> 한글 처리 & 출력 객체 생성 및 출력

		StudentService service = new StudentService();
		// => 요청 Service 처리

		List<StudentDTO> list = service.selectList();
		// => 출력할 DataList 가져오기

		response.setContentType("text/html; charset=UTF-8");
		// => 한글 처리

		PrintWriter out = response.getWriter();
		// => 출력 객체 생성

		out.print("<html><body>");
		out.print("<h2 style = 'color:green'>** Servelt Student List **</h2>");

		if (list != null) {
			for (StudentDTO s : list) {
				out.print(s + "<br>");
			}
		} else {
			System.out.println("** 출력할 Data 없음 **");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
