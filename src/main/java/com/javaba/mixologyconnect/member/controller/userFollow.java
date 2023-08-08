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

@WebServlet("/member/userFollow")
public class userFollow extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	try {
		
		int loginMemberNo = Integer.parseInt(req.getParameter("loginMemberNo"));
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		int followCheck = Integer.parseInt(req.getParameter("followCheck"));
		
		
		MemberService service = new MemberService();
		
		Map<String, Integer> follow = service.userFollowInsertDelete(loginMemberNo, memberNo, followCheck);
		
		new Gson().toJson(follow,resp.getWriter());
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}

}
