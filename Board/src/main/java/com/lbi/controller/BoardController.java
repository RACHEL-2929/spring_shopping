package com.lbi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;
import com.lbi.model.PageMakerDTO;
import com.lbi.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService bservice;

	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {
		log.info("게시판 목록 페이지 진입");
		log.info("cri : " + cri);
		model.addAttribute("list", bservice.getListPaging(cri));
		int total = bservice.getTotal(cri);
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker", pageMake);

	}

	@GetMapping("/enroll")
	public void boardEnrollGET() {
		log.info("게시판 등록 페이지 진입");
	}

	@PostMapping("/enroll")
	public String boardEnrollPost(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardVO : " + board);
		bservice.enroll(board);
		rttr.addFlashAttribute("result", "enroll success");

		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void boardGetPageGET(int bno,Model model) {
		model.addAttribute("pageInfo",bservice.getPage(bno));
	}
	
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model) {
		model.addAttribute("pageInfo",bservice.getPage(bno));
	}

	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		bservice.modify(board);
		rttr.addFlashAttribute("result", "modify success");

		return "redirect:/board/list";
	}
	
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr ) {
		bservice.delete(bno);
		rttr.addFlashAttribute("result", "delete success");

		return "redirect:/board/list";
	}
}
