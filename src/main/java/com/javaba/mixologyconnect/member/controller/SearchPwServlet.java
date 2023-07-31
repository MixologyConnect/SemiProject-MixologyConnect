package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;


@WebServlet("/member/searchPw")
public class SearchPwServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String path ="/WEB-INF/views/member/searchPw.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("inputId");
		String memberName = req.getParameter("inputName");
		
		try {
			
			MemberService service = new MemberService();
			
			Member member = service.searchPw(memberId, memberName);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
