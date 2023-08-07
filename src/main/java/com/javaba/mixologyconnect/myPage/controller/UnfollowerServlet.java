package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.member.model.service.MemberService;

@WebServlet("/myPage/unfollow")
public class UnfollowerServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int loginMemberNo = Integer.parseInt(req.getParameter("loginMemberNo"));
			int unfollowerNo = Integer.parseInt(req.getParameter("unfollowerNo"));
			
			MemberService service = new MemberService();
			
			int result = service.unfollow(loginMemberNo, unfollowerNo);
			
			new Gson().toJson(result, resp.getWriter());
		}catch (Exception e) {
			e.printStackTrace();
		
		}
	
	
	
	}

}
