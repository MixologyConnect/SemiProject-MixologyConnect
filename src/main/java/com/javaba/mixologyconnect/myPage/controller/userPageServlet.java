package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;

@WebServlet("/myPage/userPage")
public class userPageServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MypageService myPageService = new MypageService();
			MemberService memberService = new MemberService();

//			HttpSession session = req.getSession();
			
			int memberNo = 0;
			
			if (req.getParameter("memberNo") != null) {
			memberNo = Integer.parseInt(req.getParameter("memberNo"));
			System.out.println(memberNo);
		        }
		    
			int cp = 1;
			if (req.getParameter("cp") != null)
				cp = Integer.parseInt(req.getParameter("cp"));

			Map<String, Object> map = myPageService.selectuserPageList(cp, memberNo);

			req.setAttribute("map", map);

			req.setAttribute("followers", memberService.selectFollowers(memberNo));
			req.setAttribute("followings", memberService.selectFollowings(memberNo));

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/myPage/userPage.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
