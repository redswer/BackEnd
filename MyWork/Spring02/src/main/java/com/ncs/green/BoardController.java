package com.ncs.green;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;

@AllArgsConstructor
@RequestMapping(value = "/board")
@Controller
public class BoardController {

	BoardService service;

	// * replyInsert
	// => root, step, indent 를 replyInsert Form 으로 전달해야 함
	// => 매핑 메서드의 인자로 정의된 dto 는 request.setAttribute 와 동일한 scope
	// => 따라서 response 출력 전까지는 사용 가능하므로 model.addAttribute 구문 필요 없음

	@GetMapping(value = "/replyInsert")
	public void replyInsert(BoardDTO dto) {

	}

	@PostMapping(value = "/rinsert")
	public String rinsert(Model model, BoardDTO dto, RedirectAttributes rttr) {
		String uri = "redirect:boardList";

		// ** 답글 등록
		// => sql 구문 : insert
		// ** step -> 출력 순서 (마지막에 쓴 글이 제일 위로 오도록 정렬)
		// => 성공 시 boardList, 실패 시 입력 폼으로 이동

		dto.setStep(dto.getStep() + 1);
		dto.setIndent(dto.getIndent() + 1);
		// => dto 의 값
		// -> id, title, content : 그대로 사용 가능
		// -> 부모 글의 root : 동일함
		// -> step, indent : 부모 글 보다 1 증가해야 함

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
	// => 조회수 증가 처리
	// -> Table 의 cnt=cnt+1
	// -> Update 메서드 활용
	// - mapper 의 xml 수정 (Mybatis)
	// - bUpdateForm 에서 cnt값 전달 가능하도록 수정

	@GetMapping(value = "/bdetail")
	public String bdetail(HttpServletRequest request, Model model, BoardDTO dto) {
		// 1. detail service 처리
		dto = service.selectOne(dto);

		// 2. 조회수 (cnt) 증가 처리
		// -> 글보는이(loginID)와 글쓴이가 다를때
		// -> 글보는이(loginID)가 "admin" 이 아닌경우
		// -> 수정요청이 아닌경우 (jCode != U)
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
	// => 성공하면 boardList 로, 실패하면 재입력 boardInsert 로

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
	// => 성공하면 boardDetail 로, 실패하면 boardUpdate 로

	@PostMapping(value = "bupdate")
	public String bUpdate(BoardDTO dto, Model model, HttpSession session) {

		model.addAttribute("apple", dto);
		// => 처리결과에 따른 화면 출력을 위해 dto 의 값을 attribute 에 보관

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

} // class
