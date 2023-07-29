package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.BookMark;

@WebServlet("/myPage/bookMarkList")
public class BookMarkListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardService service = new BoardService();
		
		try {
			// 현재머물고 있는 페이지의 게시글 번호 얻어오기
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			BookMark bookMark = service.bookMarkList(boardNo);
			
			// 북마크 게시글 조회
			
			// JSON 변환 + 응답
			new Gson().toJson(bookMark, resp.getWriter());
			System.out.println("보드리스트 : " + bookMark);
			
			req.setAttribute("bookMark", bookMark);
			System.out.println("북마크 : " + bookMark);
			
			String path = "/WEB-INF/views/myPage/bookMark.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
			// 북마크 테이블 삽입
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
