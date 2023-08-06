package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.member.model.service.MemberService;

@WebServlet("/myPage/cancleFollower")
public class CancelFollowerServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int loginMemberNo = Integer.parseInt(req.getParameter("loginMemberNo"));
			int cancleFollower = Integer.parseInt(req.getParameter("cancleFollower"));
			
			MemberService service = new MemberService();
			
			int result = service.cancleFollower(loginMemberNo, cancleFollower);
			
			System.out.println("여기까지 왔니?"+result);
			new Gson().toJson(result, resp.getWriter());
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
		
	}
}
