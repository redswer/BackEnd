package myDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import service.MemberService;

public class C01_MList implements MyController {
	
	@Autowired
	MemberService service;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("banana", service.selectList());
		
		return "member/memberList";
	}
	
}
