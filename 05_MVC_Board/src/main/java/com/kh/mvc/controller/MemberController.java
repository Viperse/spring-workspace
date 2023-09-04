package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(Member vo, Model model, Authentication auth) {
		Member member = service.login(vo);
		Member member2 = (Member)auth.getAuthorities();
		model.addAttribute("info", member2);
		return "redirect:/";
	}
	
	@GetMapping("/regster")
	public void register() {}
	
	@PostMapping("/register")
	public String register(Member vo) {
		String encodePassword = bcpe.encode(vo.getPassword());
		vo.setPassword(encodePassword);
		service.registerMember(vo);
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public void logout() {}

}
