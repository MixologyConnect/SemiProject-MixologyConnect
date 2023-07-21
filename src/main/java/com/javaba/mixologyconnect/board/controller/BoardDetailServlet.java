package com.javaba.mixologyconnect.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	try {
		
		//int boardNo = Integer.parseInt(req.getParameter("no"));
		
		String path = "/WEB-INF/views/board/boardDetail.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	
	
	
	}

}