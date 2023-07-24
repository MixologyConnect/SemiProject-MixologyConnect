package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;


@WebServlet("member/myPage/secession")
public class MyPageSecessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/secession.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberPw = req.getParameter("memberPw");

		// 회원번호
		HttpSession session = req.getSession(); // 세션 얻어오기

		Member loginMember = (Member)(session.getAttribute("loginMember"));

		int memberNo = loginMember.getMemberNo();

		try {
			MemberService service = new MemberService();

			int result = service.secession(memberNo,memberPw);

			String path = null; 

			if(result > 0) { // 성공

				session.invalidate(); // 세션 무효화

				session = req.getSession(); // 무효화 후 새로 생성된 세션 얻어오기

				session.setAttribute("message", "탈퇴 되었습니다.");

				path = req.getContextPath(); // 메인 페이지

				Cookie c = new Cookie("saveId",""); // 쿠키 생성
				c.setMaxAge(0); // 쿠키 수명
				c.setPath(req.getContextPath()); // 쿠키 적용 경로
				resp.addCookie(c); // 쿠키 클라이언트에 전송

			}else { // 실패
				session.setAttribute("message", "비밀번호가 일치하지 않습니다.");

				path = "secession";

			}

			resp.sendRedirect(path);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
