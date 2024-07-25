package com.vam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.AuthorVO;
import com.vam.model.Criteria;
import com.vam.model.PageDTO;
import com.vam.service.AuthorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AuthorService authorService;
    
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@GetMapping("goodsManage")
	public void goodsManageGET() {
		logger.info("상품 등록 페이지 접속");
	}
	@GetMapping("goodsEnroll")
	public void goodsEnrollGET() {
		logger.info("상품 등록 페이지 접속");
	}
	@GetMapping("authorEnroll")
	public void authorEnrollGET() {
		logger.info("작가 등록 페이지 접속");
	}
	@GetMapping("/authorManage")
	public void authorManageGET(Criteria cri, Model model) {
		logger.info("작가 관리 페이지 접속");
		
		List<AuthorVO> list = authorService.authorGetList(cri);
		
		model.addAttribute("list", list);
		
        /* 페이지 이동 인터페이스 데이터 */
        int total = authorService.authorGetTotal(cri);
        
        PageDTO pageMaker = new PageDTO(cri, total);
        
        model.addAttribute("pageMaker", pageMaker);
	}
	
	
	
	
	@GetMapping("/main")
	public void adminMainGET() {
		logger.info("관리자 페이지 이동");
	}
	
	@PostMapping("/authorEnroll.do")
	public String authorEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{
		logger.info("authorEnroll : "+ author);
		
		authorService.authorEnroll(author);
		rttr.addFlashAttribute("enroll_result",author.getAuthorName());
		
		return "redirect:/admin/authorManage";
    }
	
	
	
}
