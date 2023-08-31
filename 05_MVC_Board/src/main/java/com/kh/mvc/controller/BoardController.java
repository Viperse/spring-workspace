package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		List<Board> list = service.selectAllBoard(cri);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
	}
	
//	@PostMapping("/list")
//	@PutMapping("/list")
//	@DeleteMapping("/list")
	
	@GetMapping("/insert") // 게시글 등록 버튼 눌러서 페이지 이동
	public void insert() {}
	
	@PostMapping("/insert")
	public String insert(Board board) {
		service.insertBoard(board);
		return "redirect:/board/list";
	}
		
	@GetMapping("/view")
	public void view(int no, Model model) {
		Board board = service.selectBoard(no);
		model.addAttribute("vo", board);
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		service.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		service.deleteBoard(no);
		return "redirect:/board/list";
	}
}
