package servlet03_flow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDTO;
import mvcTest.StudentService;

@WebServlet("/login")
public class Ex04_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청분석
		// => 한글, request 의 parameter

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");

		int sno = 0;
		if (request.getParameter("sno") != null && request.getParameter("sno").length() > 0) {
			sno = Integer.parseInt(request.getParameter("sno"));
		}
		// => sno 를 입력하지 않은 경우를 고려하여 조건 설정
//		-------------------------------
		// 2. 서비스 처리
		// => Service, DTO 객체 생성
		// => 유저가 존재하는지 sno 로 확인 (StudentDAO 의 selectOne 메서드 사용)
		// => 존재하면 name 확인 (StudentDTO 의 name 과 parameter 의 name 비교)

		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		String uri = "";
		String message = "";

		dto.setSno(sno);
		dto = service.selectOne(dto);

//		if (dto != null) {
//			if (dto.getName().equals(name)) {
//				uri = "index.jsp";
//			} else {
//				message = "번호와 이름이 일치하지 않음";
//				uri = "servletTestForm/flowEx04_LoginForm.jsp";
//			}
//		} else {
//			message = "없는 번호";
//			uri = "servletTestForm/flowEx04_LoginForm.jsp";
//		}
		if (dto != null && dto.getName().equals(name)) {
			uri = "index.jsp";
		} else {
			message = "로그인 실패, 다시 입력";
			uri = "servletTestForm/flowEx04_LoginForm.jsp";
		}
		// => 로그인 실패 원인을 제공하지 않는 추세
//		-------------------------------
		// ** 로그인 결과에 따라 메세지 출력 (attribute)
		// => page < request < session < application

		// => 실패 시 loginForm 에 메세지 출력
		request.setAttribute("message", message);
		// => 재 로그인 시 없어져야 하기 때문에 request 에 담아야 함

		// => 성공 시 index 화면에 이름 표시 (~님 안녕하세요)
		request.getSession().setAttribute("loginName", name);
		// => 로그아웃 할 때까지 남아있어야 하기 때문에 session 에 담아야 함
		// => 따라서 로그인 정보를 session 에 보관해햐 함
		
		request.getSession().setAttribute("loginID", sno);
		// => mvc2_sDetail 을 위해 id (sno) 보관
		
//		-------------------------------
		// 3. View (Response)
		// => 성공 -> index.jsp 로
		// => 실패 -> loginForm 으로 (재로그인)
		request.getRequestDispatcher(uri).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("** doPost 실행 **");
		doGet(request, response);
	}

}
