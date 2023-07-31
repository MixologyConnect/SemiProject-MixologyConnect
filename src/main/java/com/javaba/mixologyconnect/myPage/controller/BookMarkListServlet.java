package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.member.model.vo.Member;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;
import com.javaba.mixologyconnect.myPage.model.vo.BookMark;

@WebServlet("/myPage/bookMarkList")
public class BookMarkListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MypageService service = new MypageService();
		try {
			// 현재머물고 있는 페이지의 게시글 번호 얻어오기
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			System.out.println("보드넘버값 : " + boardNo);
			
			BookMark bookMark = service.bookMarkList(boardNo);
			
			// 북마크 게시글 조회
			
			System.out.println("보드리스트 : " + bookMark);
			
			req.setAttribute("bookMark", bookMark);
			new Gson().toJson(bookMark, resp.getWriter());
			
			HttpSession session = req.getSession();
			session.setAttribute("bookMark", bookMark);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
