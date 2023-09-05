package com.kh.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kh.mvc.model.vo.Member;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		// 해도 작동되고 안 해도 작동됨
//		HttpSession session = request.getSession();
//		Member member = (Member) authentication.getPrincipal();
//		session.setAttribute("info", member);
//		
		response.sendRedirect("board/list");
	}

}
