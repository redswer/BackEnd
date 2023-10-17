package controllerM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

@WebServlet("/mdetail")
public class MVC2_mDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2_mDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 분석 & service
		// => 검색 대상의 id(sno) 필요함 -> 로그인 시 보관 (로그인 페이지 코드에 추가)
		// => session 에서 getAttribute		
		String id = (String) request.getSession().getAttribute("id");
		
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto = service.selectOne(dto);
		
		// 2. View 준비
		// => 결과를 view 가 인식 가능하도록 setAttribute
		// => Forward 로 연결
		request.setAttribute("apple", dto);
		
		request.getRequestDispatcher("member/memberDetail.jsp").forward(request, response);
	}
}
