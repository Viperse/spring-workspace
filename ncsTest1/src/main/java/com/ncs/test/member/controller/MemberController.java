package com.ncs.test.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@PostMapping("login")
	public String MemberLogin(Member vo, HttpServletRequest request, Model model) {
		Member member = service.loginMember(vo);
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", member);
		if(member != null) {
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그인 실패");
			return "errorPage";
		}
	}

}
