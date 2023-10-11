package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessioni")
public class Ex02_SessionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_SessionInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Session 인스턴스 생성
		// => session 객체는 클라이언트가 접속함과 동시에 서버에서 자동 생성
		// -> 이 값을 코드 내에서 사용하기 위해 전달받아야 함
		HttpSession session = request.getSession();
//		---------------------------------
		// 2. Session Info 출력
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		// => 날짜와 시간을 출력하기 위한 객체 생성

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<h2>** Session Infomation **</h2>");
		out.print("<h3>* session_ID => " + session.getId() + "</h3>");

		out.print("<h3>* 현재 시간 => " + formatter.format(now) + "</h3>");

		now.setTime(session.getCreationTime());
		out.print("<h3>* session 생성 시간 => " + formatter.format(now) + "</h3>");

		now.setTime(session.getLastAccessedTime());
		out.print("<h3>* 마지막 접근 시간 => " + formatter.format(now) + "</h3>");
//		--------------------------------------
		// 3. Session Time 설정 (제한시간 설정)

		// 3-1) 메서드 활용
		session.setMaxInactiveInterval(10); // 10초
		// => 단위 : 초 / 1시간 : 60*60
		// => 10초 후에 페이지를 새로고침하면 session_ID 와 creationTime 모두 바뀜

		// 3-2) 설정파일 (web.xml)
		// => Tag session-config 의 subTag session-timeout

//		--------------------------------------
		// 4. Session 무효화 (종료)
		// => invalidate : 무효화
		// 세션객체 자체를 소멸시키는것이 아니라, 세션을 초기화하고 무효화시킴.
		// session 이 null 이 아니고 session = ""

//		session.invalidate();
		// => 새로고침 할 때마다 새로운 세션 생성 -> 로그아웃 기능 구현 시 활용

		// ** 쿼리스트링을 이용하여 테스트
		// => sessioni?jCode=D 요청이 들어오면 invalidate 적용
		// => 주의 : jCode 라는 Parameter 가 없는 경우에는 null 을 리턴함
		// -> NullPointException 을 예방하도록 작성
		if ("D".equals(request.getParameter("jCode"))) {
			session.invalidate();
			System.out.println("** session 무효화 성공 **");
			out.print("<h2>** 세션 종료됨 **</h2>");
			return;
			// => return 이므로 밑의 out.print 실행하지 않고 바로 종료됨
		}

		out.print("<h2>** 정상 종료 **</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class