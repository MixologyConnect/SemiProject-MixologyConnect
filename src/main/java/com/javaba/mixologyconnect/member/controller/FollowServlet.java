package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.member.model.service.MemberService;

@WebServlet("/member/follow")
public class FollowServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	try {
		
		int loginMemberNo = Integer.parseInt(req.getParameter("loginMemberNo"));
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		int followCheck = Integer.parseInt(req.getParameter("followCheck"));
		
		
		MemberService service = new MemberService();
		
		Map<String, Integer> follow = service.followInsertDelete(loginMemberNo, boardNo, followCheck);
		
		new Gson().toJson(follow,resp.getWriter());
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}

}
