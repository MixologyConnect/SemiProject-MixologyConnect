package com.javaba.mixologyconnect.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/manager/manager/selectMember")
public class memberSelectServlet extends HttpServlet {


	@Override protected void doPost(HttpServletRequest req, HttpServletResponse
			resp) throws ServletException, IOException { 

		String memberId = req.getParameter("memberId");

		try { 

			MemberService service = new MemberService();

			Member member = new Member();

			member	=service.selectMember(memberId);

			new Gson().toJson(member, resp.getWriter());

		} catch (Exception e) { e.printStackTrace(); }

	}


}
