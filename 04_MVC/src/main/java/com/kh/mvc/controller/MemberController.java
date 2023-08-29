package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.dao.MemberDAO;
import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		System.out.println(keyword);
		
		// 서비스 - 비즈니스 로직 처리!
		// --> list 값! 데이터 바인딩 -> Model
		// model.addAttribute("list", list)
		List<Member> list = service.findMember(keyword);
		model.addAttribute(list);
		
		if(list == null) {
			return "find_fail";
		}
		return "find_ok"; // "find_fail"
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("signUp")
	public String singUp(Member member) {	
		// 비즈니스 로직
		service.registerMember(member);
		return "redirect:/";
	}
	
	// login - 페이지 이동
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	// signIn 비즈니스 로직 포함 : 파라미터 값 -> HttpServletRequest request
	//   -> return "login_result"
	@RequestMapping("signIn")
	public String signIn(HttpServletRequest request, Member member) {
		service.registerMember(member);
		HttpSession session = request.getSession();
		session.setAttribute("vo", member);
		return "login_result";
	}
	
	// allMember - 비즈니스 로직 포함, 데이터바인딩 - Model
	// return "find_ok";
	@RequestMapping("allMember")
	public String allMember(Model model) {
		List<Member> list = service.allShowMember();
		model.addAttribute(list);
		return "find_ok";
	}
	
	// logout - 로그아웃 기능!
	
	// update - 페이지 이동
	@RequestMapping("update")
	public String update() {
		return "update";
	}
	
	// updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요
	@RequestMapping("updateMember")
	public String updateMember(HttpServletRequest request, Member member) {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!= null) {
			service.updateMember(member);
			session.setAttribute("vo2", member);
		}
		return "update_result";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo") != null) {
			session.invalidate();
		} return "logout";
	}
}
