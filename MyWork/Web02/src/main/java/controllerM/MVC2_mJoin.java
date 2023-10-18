package controllerM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

@WebServlet("/mjoin")
public class MVC2_mJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2_mJoin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석 & Service
		// => post 로도 test 하기 때문에 한글처리 필요
		// => input 으로 입력받은 request Parameter 처리
		
		request.setCharacterEncoding("UTF-8");
		// => get 방식에서는 생략 가능
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int jno = Integer.parseInt(request.getParameter("jno"));		
		String info = request.getParameter("info");
		Double point = Double.parseDouble(request.getParameter("point"));
		String birthday = request.getParameter("birthday");
		String rid = request.getParameter("rid");
		
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
				
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setAge(age);
		dto.setJno(jno);
		dto.setInfo(info);
		dto.setPoint(point);
		dto.setBirthday(birthday);
		dto.setRid(rid);
		
		// 2. 결과처리
		// => 성공 : 로그인 유도 (로그인 Form 으로)
		// => 실패 : 재가입 유도 (Join Form 으로)
		String uri = "member/loginForm.jsp";
		
		if (service.insert(dto) > 0 ) {
			request.setAttribute("message", "회원가입 성공, 로그인 후 이용하세요");
		} else {
			uri = "member/memberJoin.jsp";
			request.setAttribute("message", "회원가입 실패, 다시 입력하세요");
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}// class