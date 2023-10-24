package com.ncs.green;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.MemberDTO;
import lombok.extern.log4j.Log4j;
import service.MemberService;

//** @RequestMapping
//=> DefaultAnnotationHandlerMapping에서 컨트롤러를 선택할 때 대표적으로 사용하는 애노테이션. 
//=> DefaultAnnotationHandlerMapping은 클래스와 메서드에 붙은 @RequestMapping 애노테이션 정보를 결합해 최종 매핑정보를 생성한다.
//=> 기본적인 결합 방법은 클래스 레벨의 @RequestMapping을 기준으로 삼고, 
//  메서드 레벨의 @RequestMapping으로 세분화하는 방식으로 사용된다.

//** @RequestMapping 특징
//=> url당 하나의 컨트롤러에 매핑되던 다른 핸들러 매핑과 달리 메서드 단위까지 세분화하여 적용할 수 있으며,
//url 뿐 아니라 파라미터, 헤더 등 더욱 넓은 범위를 적용할 수 있다. 
//=> 요청과 매핑메서드 1:1 mapping 
//=> value="/mlist" 
// : 이때 호출되는 메서드명과 동일하면 value 생략가능 그러나 value 생략시 404 (확인필요함)
// : 해당 메서드 내에서 mv.setViewName("...."); 을 생략 
//또는 아래의 메서드를 사용하는 경우에는 void 로 작성 (view 를 return 하지않음) 하는 경우
//   요청명을 viewName 으로 인식 즉, mv.setViewName("mlist") 으로 처리함.

//** @RequestMapping 속성
//=> value : URL 패턴 ( 와일드카드 * 사용 가능 )
//  @RequestMapping(value="/post")
//  @RequestMapping(value="/post.*")
//  @RequestMapping(value="/post/**/comment")
//  @RequestMapping(value={"/post", "/P"}) : 다중매핑 가능

//=> method 
// @RequestMapping(value="/post", method=RequestMethod.GET)
// -> url이 /post인 요청 중 GET 메서드인 경우 호출됨
// @RequestMapping(value="/post", method=RequestMethod.POST)
// -> url이 /post인 요청 중 POST 메서드인 경우 호출됨
//    GET, POST, PUT, DELETE, OPTIONS, TRACE 총 7개의 HTTP 메서드가 정의되어 있음.
//    ( 이들은 아래 @GetMapping ... 등으로도 좀더 간편하게 사용가능 )  
//( 이들은 아래 @GetMapping ... 등으로도 좀더 간편하게 사용가능
//그러나 이들은 메서드 레벨에만 적용가능    )  

//=> params : 요청 파라미터와 값으로도 구분 가능함.
// @RequestMapping(value="/post", params="useYn=Y")
// -> /post?useYn=Y 일 경우 호출됨
// @RequestMapping(value="/post", params="useYn!=Y")
// ->  not equal도 가능
// @RequestMapping(value="/post", parmas="useYn")
// > 값에 상관없이 파라미터에 useYn이 있을 경우 호출됨
// @RequestMapping(value="/post", params="!useYn")
// > 파라미터에 useYn이 없어야 호출됨
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//** Lombok 지원 로그메시지  
//=> @Log4j Test
// -> dependency 필요함 (pom.xml 확인)
// -> 로깅레벨 단계 준수함 ( log4j.xml 의 아래 logger Tag 의 level 확인)
//TRACE > DEBUG > INFO > WARN > ERROR > FATAL(치명적인)
// <logger name="com.ncs.green">
//    <level value="info" />
// </logger>   

// -> Logger 사용과의 차이점 : "{}" 지원안됨, 호출 명 : log
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

@Log4j // lombok 이 제공하는 log4j 메세지 사용 가능
@RequestMapping(value = "/member") // "/member" 로 시작하는 모든 요청을 처리
@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	// ** Lombok 의 log4j test
	@GetMapping(value="/log4jtest")
	public String log4jtest() {
		String name = "바나나";
		
		log.error("** 롬복 log_레벨 error => name = " + name);
		log.warn("** 롬복 log_레벨 warn => name = " + name);
		log.info("** 롬복 log_레벨 info => name = " + name);
		log.debug("** 롬복 log_레벨 debug => name = " + name);
		log.trace("** 롬복 log_레벨 trace => name = " + name);
		// => HomeController 에서와 마찬가지로 log4j.xml 에서 범위가 info 로 설정되어 있으므로 info 까지만 출력됨
		
		return "redirect:/";
	}

	// ** MemberList

//	@RequestMapping(value = "/mlist", method = RequestMethod.GET)
//	public String mlist(Model model) {
//		model.addAttribute("banana", service.selectList());
//		return "member/memberList";
//	}

	@GetMapping(value = "/memberList")
	public void mlist(Model model) {
		model.addAttribute("banana", service.selectList());
	}
//	=======================================
	// ** MemberDetail

//	@RequestMapping(value = "/mdetail", method = RequestMethod.GET)
	@GetMapping(value = "/mdetail")
	public String mdetail(HttpServletRequest request, Model model, MemberDTO dto) {
		// dto.setId("검색id");
		model.addAttribute("apple", service.selectOne(dto));
		if ("U".equals(request.getParameter("jCode"))) {
			return "member/memberUpdate";
		} else {
			return "member/memberDetail";
		}
	}
//	========================================
	// ** Member Login & Logout

	// * LoginForm 으로 이동 : Get

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginForm() {
//		return "member/loginForm";
//	}

	@GetMapping(value = "/loginForm")
	public void loginForm() {
		// viewName 생략 가능 (요청명이 viewName 이 됨)
	}
//	----------------------
	// * Login 처리 : Post

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping(value = "/login")
	public String login(HttpSession session, Model model, MemberDTO dto) {
		// ** 로그인 Service 처리
		// 1. 요청분석
		// => requst 로 전달되는 id, password 처리:
		// 매서드 매개변수로 MemberDTO 를 정의해주면 자동 처리
		// ( Parameter name 과 일치하는 setter 를 찾아 값을 할당해줌 )
		// => 전달된 password 보관
		String password = dto.getPassword();
//		String uri = "redirect:home";
		String uri = "redirect:/";
		// "home" -> home.jsp (성공)
		// "redirect:home" -> home 을 재요청, 그러므로 HomeController 의 home 메서드로

		// 2. 서비스 처리
		// => id 확인
		// => 존재하면 Password 확인
		// => 성공: id, name은 session에 보관, home 으로
		// => 실패: 재로그인 유도
		dto = service.selectOne(dto);
		if (dto != null && dto.getPassword().equals(password)) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
		} else {
			uri = "member/loginForm";
			model.addAttribute("message", "로그인 실패! 다시 하세요 ~~");
		}
		// System.out.println("** Login Post 처리 준비중 **");
		return uri;
	}
//	--------------------------
	// * Logout
	// => session 무효화, home으로

//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, Model model, RedirectAttributes rttr) {

		session.invalidate();
		// model.addAttribute("message", "~~ 로그아웃 성공 ~~");

		// => 단, request에 보관한 값들은 사라지므로 위의 메세지 처리를 고려해야함.
		// => session에 보관 ( 이미 세션을 무효화 했으므로 500 발생 )
		// => 그리고 session 무효화를 하지 않더라도 이 메시지는 사용후 삭제를 해야함.
		// session.setAttribute("message", "~~ 로그아웃 성공 ~~");
		// => 이렇게 redirect 하는경우 메시지처리 등을 편리하게
		// 지원해주는 객체가 RedirectAttributes
		rttr.addFlashAttribute("message", "~~ 로그아웃 성공 ~~");
//		return "redirect:home";
		return "redirect:/";
	}
//	=================================================
	// ** Join 기능

	// * JoinForm 으로 이동: GET

//	@RequestMapping(value = "/join", method = RequestMethod.GET)
//	public String memberJoin() {
//		return "member/memberJoin";
//	}
	// => 계층적 url 적용
	@GetMapping(value = "/memberJoin")
	public void memberJoin() {
		// viewName 생략 -> 요청명이 viewName 이 됨
	}
//	-------------------
	// * Join Service 처리: POST

//	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@PostMapping(value = "/join")
	public String join(MemberDTO dto, Model model) {
		// 1. 요청분석 & Service
		// => 한글처리 필수 : web.xml 에서 filter로 처리
		// => request Parameter 처리: 매개변수로 MemberDTO 정의하면 자동으로 set
		// => 성공: 로그인유도 (loginForm 으로, member/loginForm.jsp)
		// => 실패: 재가입유도 (joinForm 으로, member/memberJoin.jsp)
		String uri = "member/loginForm";

		// 2. Service 처리
		if (service.insert(dto) > 0) {
			model.addAttribute("message", "~~ 회원가입 성공!! 로그인후 이용하세요 ~~");
		} else {
			model.addAttribute("message", "~~ 회원가입 실패!! 다시 하세요 ~~");
			uri = "member/memberJoin";
		}

		// 3. View
		return uri;
	}
//	===============================================
	// ** Member Update
	// 요청 : home 에서 내정보 수정 -> 정보 수정 form (memberUpdate.jsp)
	// -> 수정 후 submit -> 수정 service
	// -> 성공 시 detail 페이지 / 실패 시 재시도 (memberUpdate.jsp)

//	@RequestMapping(value = "/mupdate", method = RequestMethod.POST)
	@PostMapping(value = "mupdate")
	public String memberUpdate(MemberDTO dto, Model model, HttpSession session) {

		model.addAttribute("apple", dto);
		// => 처리결과에 따른 화면 출력을 위해 dto 의 값을 attribute 에 보관

		String uri = "member/memberDetail";
		if (service.update(dto) > 0) {
			model.addAttribute("message", "회원정보 수정 완료");
		} else {
			model.addAttribute("message", "회원정보 수정 실패");
			uri = "member/memberUpdate";
		}

		return uri;
	}
//	===============================================
	// ** Member Delete: 회원탈퇴
	// => 삭제대상 : Parameter 로 전달, dto에 자동 set

//	@RequestMapping(value = "/mdelete", method = RequestMethod.GET)
	@GetMapping(value = "/mdelete")
	public String mdelete(HttpSession session, MemberDTO dto, Model model, RedirectAttributes rttr) {

		// 1) 본인탈퇴
		// 결과 : message(삭제 성공/실패), home.jsp, session 무효화

		// 2) 관리자에 의한 강제탈퇴
		// 결과 : message(삭제 성공/실패), memberList.jsp

		// => 본인탈퇴 or 관리자에 의한 강제탈퇴 구분이 필요
		// dto 의 id 와 session 의 loginID 와 같으면 본인탈퇴,
		// 다르면서 session 의 loginID 값이 "admin" 이면 강제탈퇴
		String uri = "redirect:/";

		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "~~ 탈퇴 성공!! 1개월후 재가입 가능 합니다 ~~");
			if (((String) session.getAttribute("loginID")).equals("admin")) {
				// => 관리자에 의한 강제탈퇴
				uri = "redirect:memberList";
			} else {
				// => 본인탈퇴
				session.invalidate();
			}
		} else {
			rttr.addFlashAttribute("message", "~~ 탈퇴 실패 ~~");
		}
		return uri;
	}

} // class
