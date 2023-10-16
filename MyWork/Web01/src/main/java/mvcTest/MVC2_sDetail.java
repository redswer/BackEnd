package mvcTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class MVC2_sDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2_sDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 분석 & service
		// => 검색 대상의 id(sno) 필요함 -> 로그인 시 보관 (로그인 페이지 코드에 추가)
		// => session 에서 getAttribute		
		int sno = (Integer) request.getSession().getAttribute("loginID");
		
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);
		dto = service.selectOne(dto);
		
		// 2. View 준비
		// => 결과를 view 가 인식 가능하도록 setAttribute
		// => Forward 로 연결
		request.setAttribute("apple", dto);
		
		request.getRequestDispatcher("jsp99_mvcTest/mvc2_sDetail.jsp").forward(request, response);
	}
}
