package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/myPage/followerList")
public class FollowerListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			HttpSession session = req.getSession();
//
//			Member loginMember = (Member)(session.getAttribute("loginMember") );
			MemberService service = new MemberService();
//
//			int memberNo = loginMember.getMemberNo();

			int memberNo = Integer.parseInt(req.getParameter("boardMemberNo"));
			

			List<Member> followers = service.selectFollowers(memberNo);

			System.out.println("MM:"+followers);
			System.out.println("ss:"+followers.size());

			new Gson().toJson(followers, resp.getWriter());



		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
