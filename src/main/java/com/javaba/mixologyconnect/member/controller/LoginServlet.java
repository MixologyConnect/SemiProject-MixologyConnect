package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberService();
		HttpSession session = req.getSession(); 

		try {
			String inputId = req.getParameter("inputId");
			Member loginMember = service.login(inputId, req.getParameter("inputPw"));

			if(loginMember != null) {
				session.setAttribute("loginMember", loginMember);
				session.setMaxInactiveInterval(3600);
				Cookie c = new Cookie("saveId", inputId); 
				if(req.getParameter("inputSaveId") != null) c.setMaxAge(60 * 60 * 24 * 30);
				else c.setMaxAge(0);
				c.setPath( req.getContextPath() );
				resp.addCookie(c);
			}
			else session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			session.setMaxInactiveInterval(3600);

			//resp.sendRedirect(req.getContextPath());
			resp.sendRedirect(req.getHeader("referer"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
