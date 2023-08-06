package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;

@WebServlet("/myPage/myPage")
public class LoginMyPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MypageService myPageService = new MypageService();
			MemberService memberService = new MemberService();

			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember") );

			int cp = 1;
			if(req.getParameter("cp") != null) cp = Integer.parseInt(req.getParameter("cp"));

			Map<String, Object> map = myPageService.selectMypageList(cp, loginMember);

			req.setAttribute("map", map);

			int memberNo = loginMember.getMemberNo();
			req.setAttribute("followers", memberService.selectFollowers(memberNo));
			req.setAttribute("followings", memberService.selectFollowings(memberNo));
			req.setAttribute("loginMemberNo", loginMember.getMemberNo());

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/myPage/myPage.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
