package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;


@WebServlet("/member/searchId")
public class SearchIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String path ="/WEB-INF/views/member/searchId.jsp";

		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 파라미터 얻어오기
		String memberName = req.getParameter("memberName");
		String memberTel = req.getParameter("memberTel");
		
		
		try {
			
			MemberService service = new MemberService();
			
			Member member   = service.searchId(memberName, memberTel);
			
			new Gson().toJson(member, resp.getWriter());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
}