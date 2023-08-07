package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/myPage/followingList")
public class FollowingListServlet extends HttpServlet {
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
			System.out.println("memberNo"+memberNo);
			List<Member> followings = service.selectFollowings(memberNo);
			
//			System.out.println("MM:"+followings);
//			System.out.println("ss:"+followings.size());
			
			new Gson().toJson(followings, resp.getWriter());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	

}
