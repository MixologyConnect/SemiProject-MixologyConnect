package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/myPage/userPageFollower")
public class userPageFollower extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		try {

			HttpSession session = req.getSession();
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			int loginMemberNo =loginMember.getMemberNo();// 로그인한 회원의 memberNo
			
			
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			MemberService service = new MemberService();
			
			int result = service.userPageFollower(memberNo, loginMemberNo);
			
			
			String message = null;
			
			String path = "/WEB-INF/views/myPage/userPage.jsp";
			
			
			if(result > 0) {
				message = ("팔로우 되었습니다.");
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
				
			}else {
				message = ("팔로우 실패");
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

}
