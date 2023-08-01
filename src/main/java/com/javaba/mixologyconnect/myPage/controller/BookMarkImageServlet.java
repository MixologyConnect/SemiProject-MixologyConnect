package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.member.model.vo.Member;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;

@WebServlet("/myPage/bookMarkImage")
public class BookMarkImageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember") );

			MypageService service = new MypageService();
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			int result = service.existNo(boardNo, loginMember);
			
			resp.getWriter().print(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
		
	}
	
}
