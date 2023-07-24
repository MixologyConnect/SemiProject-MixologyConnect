package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/member/myPage/changePw")
public class ChangePwServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path="/WEB-INF/views/member/myPage-info.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String currentPw= req.getParameter("currentPw");
		String newPw = req.getParameter("newPw");

		HttpSession session = req.getSession();

		Member loginMember = (Member)(session.getAttribute("logingMember"));
		int memberNo = loginMember.getMemberNo();

		System.out.print(currentPw);
		System.err.println(newPw);
		System.out.println(memberNo);

		try {
			MemberService service = new MemberService();
			int result = service.changePw(currentPw, newPw, memberNo);

			if(result > 0) {
				session.setAttribute("message", "비밀번호 변경 성공");

			}else {
				session.setAttribute("message", "현재 비밀번호가 일치하지 않습니다.");

			}
			
			resp.sendRedirect("info");
		}catch (Exception e) {
			e.printStackTrace();		
		}

	}

}
