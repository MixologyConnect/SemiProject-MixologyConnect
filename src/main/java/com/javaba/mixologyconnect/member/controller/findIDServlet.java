package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.member.model.service.MemberService;

@WebServlet("/member/findID")
public class findIDServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberService service = new MemberService();

		try {
			resp.getWriter().print(service.findID(req.getParameter("name"),
												  req.getParameter("email")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
