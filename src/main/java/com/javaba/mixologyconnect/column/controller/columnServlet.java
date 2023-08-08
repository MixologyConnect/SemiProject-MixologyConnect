package com.javaba.mixologyconnect.column.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.BoardDetail;

@WebServlet("/column/columnDetail")
public class columnServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int boardNo = Integer.parseInt(req.getParameter("no"));
			
			BoardService service = new BoardService();
			
			BoardDetail detail = service.selectBoardDetail(boardNo);
			
			req.setAttribute("detail", detail);
			
			
			String path = "/WEB-INF/views/column/column.jsp";
			
			
			//int type = Integer.parseInt(req.getParameter("type"));
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);

			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}