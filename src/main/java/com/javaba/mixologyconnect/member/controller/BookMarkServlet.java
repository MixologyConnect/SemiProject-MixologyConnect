package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.Board;

@WebServlet("/myPage/bookMark")
public class BookMarkServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
			String path ="/WEB-INF/views/myPage/bookMark.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
	
		
	}
	
}
