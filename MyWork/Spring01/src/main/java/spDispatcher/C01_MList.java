package spDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.MemberService;

@Component
public class C01_MList implements Controller {
	
	@Autowired
	MemberService service;
//	= MemberService service = new MemberService();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("banana", service.selectList());
		mv.setViewName("member/memberList");
		
		return mv;
		
	}
	
}
