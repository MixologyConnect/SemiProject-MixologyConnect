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

@WebServlet("/myPage/bookMarkDelete")
public class BookMarkDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 로그인 멤버 얻어오기
			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember") );

			MypageService service = new MypageService();
			
			// ajax에서 현재 머물고있는 페이지의 게시글번호 얻어오기
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			// UPDATE문 결과 얻어오기
			int result = service.delete(boardNo,loginMember);
			
			// ajax로 값 넘겨주기
			resp.getWriter().print(result);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
