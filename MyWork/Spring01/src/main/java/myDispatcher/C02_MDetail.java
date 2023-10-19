package myDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

public class C02_MDetail implements MyController {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		request.setAttribute("apple", service.selectOne(dto));
		
		return "member/memberDetail";
	}

}
