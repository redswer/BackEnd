package mvcTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class MVC2_sDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MVC2_sDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청 분석 & Service
		// => 삭제할 대상은 쿼리스트링 (sno) 로 전달됨
		// => = request 의 parameter 로 전달됨

		int sno = Integer.parseInt(request.getParameter("sno"));
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);

		// 2. 결과 처리
		// => 결과에 상관없이 list 로 이동
		// => 메시지만 다르게 출력
		// => 바로 list 로 보내지 않고 list 를 생성하는 servlet 으로 보내야 함

		if (service.delete(dto) > 0) {
			// 2-1) 삭제 성공
			request.setAttribute("message", sno + "번 삭제 성공");
		} else {
			// 2-2) 삭제 실패
			request.setAttribute("message", sno + "번 삭제 실패");
		}
		request.getRequestDispatcher("list2").forward(request, response);
	}
}
