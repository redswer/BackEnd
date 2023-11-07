package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.MemberDTO;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

// ** MemberController
// => SpringBoot, JSP 사용, 계층적 uri 적용

@Controller
@RequestMapping("/member")
@Log4j2
// => Boot 에서는 2015년 이후로 @Log4j 지원 중단
@AllArgsConstructor
// => 모든 멤버변수 생성자 주입하므로 각각 @Autowired 할 필요 없음
public class MemberController {

	MemberService service;
	PasswordEncoder passwordEncoder;

	@GetMapping("/memberList")
	public void memberList(Model model) {
		model.addAttribute("banana", service.selectList());
		log.info("** MemberList 출력 성공 **");

	}

//	=======================================
	// ** MemberDetail

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

	@GetMapping(value = "/loginForm")
	public void loginForm() {
	}
//	----------------------
	// * Login 처리 : Post

	@PostMapping(value = "/login")
	public String login(HttpSession session, Model model, MemberDTO dto) {
		String password = dto.getPassword();
		String uri = "redirect:/home";

		dto = service.selectOne(dto);

		if (dto != null && passwordEncoder.matches(password, dto.getPassword())) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("img", dto.getUploadfile());
			session.setAttribute("loginName", dto.getName());
		} else {
			uri = "member/loginForm";
			model.addAttribute("message", "로그인 실패! 다시 하세요 ~~");
		}
		return uri;
	}
//	--------------------------
	// * Logout

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, Model model, RedirectAttributes rttr) {

		session.invalidate();
		rttr.addFlashAttribute("message", "~~ 로그아웃 성공 ~~");
		return "redirect:/home";
	}
//	=================================================
	// ** Join

	@GetMapping(value = "/memberJoin")
	public void memberJoin() {
	}
//	-------------------
	// * Join Service 처리: POST

	@PostMapping(value = "/join")
	public String join(MemberDTO dto, Model model, HttpServletRequest request) throws IOException {
		String uri = "member/loginForm";

		String realPath = request.getRealPath("/");

		if (realPath.contains(".eclipse.")) {
			realPath = "D:\\JinHyuk_Ahn\\BackEnd\\MyWork\\demo\\src\\main\\webapp\\resources\\uploadImage\\";
		} else {
			realPath += "resources\\uploadImage\\";
		}

		File f1 = new File(realPath);

		if (!f1.exists()) {
			f1.mkdir();
		}

		f1 = new File(realPath + "basicman4.png");
		if (!f1.isFile()) {
			String basicImagePath = "D:\\JinHyuk_Ahn\\BackEnd\\MyWork\\demo\\src\\main\\webapp\\resources\\image\\basicman4.png";

			FileInputStream fi = new FileInputStream(new File(basicImagePath));

			FileOutputStream fo = new FileOutputStream(f1);

			FileCopyUtils.copy(fi, fo);
		}

		String file1, file2 = "resources/uploadImage/basicman4.png";

		MultipartFile uploadfilef = dto.getUploadfilef();
		if (uploadfilef != null && !uploadfilef.isEmpty()) {
			file1 = realPath + uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));
			file2 = "resources/uploadImage/" + uploadfilef.getOriginalFilename();
		}

		dto.setUploadfile(file2);

		dto.setPassword(passwordEncoder.encode(request.getParameter("password")));

		if (service.insert(dto) > 0) {
			model.addAttribute("message", "~~ 회원가입 성공!! 로그인후 이용하세요 ~~");
		} else {
			model.addAttribute("message", "~~ 회원가입 실패!! 다시 하세요 ~~");
			uri = "member/memberJoin";
		}

		return uri;
	}

//	===============================================
	// ** Member Update
	@PostMapping(value = "mupdate")
	public String memberUpdate(MemberDTO dto, Model model, HttpSession session, HttpServletRequest request)
			throws IOException {

		model.addAttribute("apple", dto);

		String uri = "member/memberDetail";

		dto.setPassword(null);

		MultipartFile uploadfilef = dto.getUploadfilef();

		if (uploadfilef != null && !uploadfilef.isEmpty()) {
			String realPath = request.getRealPath("/");

			if (realPath.contains(".eclipse."))
				realPath = "D:\\JinHyuk_Ahn\\BackEnd\\MyWork\\demo\\src\\main\\webapp\\resources\\uploadImage\\";
			else
				realPath += "resources\\uploadImage\\";

			String file1 = realPath + uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));

			String file2 = "resources/uploadImage/" + uploadfilef.getOriginalFilename();
			dto.setUploadfile(file2);
		}

		if (service.update(dto) > 0) {
			session.setAttribute("img", dto.getUploadfile());
			model.addAttribute("message", "회원정보 수정 완료");
		} else {
			model.addAttribute("message", "회원정보 수정 실패");
			uri = "member/memberUpdate";
		}

		return uri;
	}
//	===============================================
	// ** Member Delete: 회원탈퇴

	@GetMapping(value = "/mdelete")
	public String mdelete(HttpSession session, MemberDTO dto, Model model, RedirectAttributes rttr) {
		String uri = "redirect:/home";

		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "~~ 탈퇴 성공!! 1개월후 재가입 가능 합니다 ~~");
			if (((String) session.getAttribute("loginID")).equals("admin")) {
				uri = "redirect:memberList";
			} else {
				session.invalidate();
			}
		} else {
			rttr.addFlashAttribute("message", "~~ 탈퇴 실패 ~~");
		}
		return uri;
	}

//	=============================================
	// ** 비밀번호 수정
	@GetMapping(value = "/memberPasswordUpdate")
	public void memberPasswordUpdate() {
	}

	@PostMapping(value = "/mpasswordupdate")
	public String mpasswordupdate(Model model, MemberDTO dto, HttpServletRequest request) {

		String id = (String) request.getSession().getAttribute("loginID");

		if (id == null) {
			model.addAttribute("message", "재로그인 필요");
			return "member/loginForm";
		}

		dto.setId(id);
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		String uri = "member/loginForm";
		if (service.update(dto) > 0) {
			request.getSession().invalidate();
			model.addAttribute("message", "패스워드 수정 완료");
		} else {
			model.addAttribute("message", "패스워드 수정 실패");
			uri = "member/memberPasswordUpdate";
		}
		return uri;
	}

//	=====================================================
	// ** id 중복확인
	@GetMapping(value = "/idDupCheck")
	public String idDupCheck(MemberDTO dto, Model model) {

		if (service.selectOne(dto) != null) {
			model.addAttribute("idUse", "F");
		} else {
			model.addAttribute("idUse", "T");
		}
		return "member/idDupCheck";
	}
}
