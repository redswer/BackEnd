package com.ncs.green;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.JoDTO;
import lombok.AllArgsConstructor;
import service.JoService;
import service.MemberService;

@AllArgsConstructor
@RequestMapping(value = "/jo")
@Controller
public class JoController {

	JoService service;
	
	MemberService mservice;
	// => 조원 출력 위한 service
	
	// ** BoardList
	
	@GetMapping(value = "/joList")
	public void joList(Model model) {
		model.addAttribute("banana", service.selectList());
	}
//	=======================================
	// ** BoardDetail

	@GetMapping(value = "/jdetail")
	public String jdetail(HttpServletRequest request, Model model, JoDTO dto) {
		
		model.addAttribute("apple", service.selectOne(dto));
		
		model.addAttribute("banana", mservice.selectJno(dto.getJno()));
		// => 조원 출력 위한 model
		
		if ("U".equals(request.getParameter("jCode"))) {
			return "jo/joUpdate";
		} else {
			return "jo/joDetail";
		}
	}
//	=================================================
	// ** insert

	@GetMapping(value = "/joInsert")
	public void joInsert() {
		
	}
//	-------------------
	// * insert Service 처리: POST
	// => 성공하면 boardList 로, 실패하면 재입력 boardInsert 로

	@PostMapping(value = "/jinsert")
	public String jinsert(JoDTO dto, Model model, RedirectAttributes rttr) {
		String uri = "redirect:joList";

		if (service.insert(dto) > 0) {
			rttr.addFlashAttribute("message", "~~ 입력 성공!! ~~");
		} else {
			model.addAttribute("message", "~~ 입력 실패!! 다시 하세요 ~~");
			uri = "jo/joInsert";
		}

		return uri;
	}
//	===============================================
	// ** Board Update
	// => 성공하면 boardDetail 로, 실패하면 boardUpdate 로

	@PostMapping(value = "jupdate")
	public String jUpdate(JoDTO dto, Model model, HttpSession session) {
		model.addAttribute("apple", dto);
		// => 처리결과에 따른 화면 출력을 위해 dto 의 값을 attribute 에 보관

		String uri = "jo/joDetail";
		if (service.update(dto) > 0) {
			model.addAttribute("message", "수정 완료");
		} else {
			model.addAttribute("message", "수정 실패");
			uri = "jo/joUpdate";
		}

		return uri;
	}
//	===============================================
	// ** Board Delete

	@GetMapping(value = "/jdelete")
	public String jdelete(HttpSession session, JoDTO dto, Model model, RedirectAttributes rttr) {
		
		String uri = "redirect:joList";

		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "~~ 삭제 성공!! ~~");
		} else {
			rttr.addFlashAttribute("message", "~~ 삭제 실패 ~~");
		}
		return uri;
	}

} // class
