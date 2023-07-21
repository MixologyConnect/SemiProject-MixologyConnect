package com.javaba.mixologyconnect.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.board.model.service.BoardService;

@WebServlet("/board/boardAll")
public class boardAllServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		try {
			String path = "/WEB-INF/views/board/boardAll.jsp";
			
			int type = Integer.parseInt(req.getParameter("no"));
			
			int cp = 1;
			
			if(req.getParameter("cp") != null) {
				Integer.parseInt(req.getParameter("cp"));
			}
			
			BoardService service = new BoardService();
			
			Map<String, Object> map = service.selectBoardAll(type, cp);
			req.setAttribute("map", map);
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
}
