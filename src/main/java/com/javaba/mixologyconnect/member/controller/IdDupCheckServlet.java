package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/member/idDupCheck")
public class IdDupCheckServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberId = req.getParameter("memberId");
		
		try {
			MemberService service = new MemberService();
			int result = service.idDupCheck(memberId);
			resp.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}