package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.BoardDTO;
import com.example.demo.service.BoardService;

import criTest.PageMaker;
import criTest.SearchCriteria;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(value = "/board")
@Controller
public class BoardController {
	BoardService service;


	@GetMapping(value = "/bcriList")
	public void bcriList(Model model, SearchCriteria cri, PageMaker pageMaker) {
		cri.setSnoEno();

		model.addAttribute("banana", service.bcriList(cri));

		pageMaker.setCri(cri);
		pageMaker.setTotalRowsCount(service.criTotalCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}

//	========================================
	// * replyInsert

	@GetMapping(value = "/replyInsert")
	public void replyInsert(BoardDTO dto) {

	}

	@PostMapping(value = "/rinsert")
	public String rinsert(Model model, BoardDTO dto, RedirectAttributes rttr) {
		String uri = "redirect:boardList";

		dto.setStep(dto.getStep() + 1);
		dto.setIndent(dto.getIndent() + 1);

		if (service.rinsert(dto) > 0) {
			rttr.addFlashAttribute("message", "답글 등록 성공");
		} else {
			model.addAttribute("message", "답글 등록 실패");
			uri = "board/replyInsert";
		}

		return uri;
	}

//	======================================

	// ** BoardList

	@GetMapping(value = "/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana", service.selectList());
	}
//	=======================================
	// ** BoardDetail

	@GetMapping(value = "/bdetail")
	public String bdetail(HttpServletRequest request, Model model, BoardDTO dto) {
		// 1. detail service 처리
		dto = service.selectOne(dto);

		String loginID = (String) request.getSession().getAttribute("loginID");

		if (!"admin".equals(loginID) && !dto.getId().equals(loginID) && !"U".equals(request.getParameter("jCode"))) {

			dto.setCnt(dto.getCnt() + 1);
			service.update(dto);
		}

		model.addAttribute("apple", dto);

		if ("U".equals(request.getParameter("jCode"))) {
			return "board/boardUpdate";
		} else {
			return "board/boardDetail";
		}
	}
//	=================================================
	// ** insert

	@GetMapping(value = "/boardInsert")
	public void boardInsert() {

	}
//	-------------------
	// * insert Service 처리: POST

	@PostMapping(value = "/binsert")
	public String binsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		String uri = "redirect:boardList";

		if (service.insert(dto) > 0) {
			rttr.addFlashAttribute("message", "~~ 등록 성공!! ~~");
		} else {
			model.addAttribute("message", "~~ 등록 실패!! 다시 하세요 ~~");
			uri = "board/boardInsert";
		}

		return uri;
	}
//	===============================================
	// ** Board Update

	@PostMapping(value = "bupdate")
	public String bUpdate(BoardDTO dto, Model model, HttpSession session) {

		model.addAttribute("apple", dto);

		String uri = "board/boardDetail";
		if (service.update(dto) > 0) {
			model.addAttribute("message", "수정 완료");
		} else {
			model.addAttribute("message", "수정 실패");
			uri = "board/boardUpdate";
		}

		return uri;
	}
//	===============================================
	// ** Board Delete

	@GetMapping(value = "/bdelete")
	public String bdelete(HttpSession session, BoardDTO dto, Model model, RedirectAttributes rttr) {

		String uri = "redirect:boardList";

		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "~~ 삭제 성공!! ~~");
		} else {
			rttr.addFlashAttribute("message", "~~ 삭제 실패 ~~");
		}
		return uri;
	}
}
