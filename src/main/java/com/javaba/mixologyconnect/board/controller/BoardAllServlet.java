package com.javaba.mixologyconnect.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.BoardDetail;
import com.javaba.mixologyconnect.board.model.vo.BoardImage;

import lombok.Builder;

@WebServlet("/board/boardAll")
public class BoardAllServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		try {
			int type = Integer.parseInt(req.getParameter("type"));
			
			int cp = 1;
			
			if(req.getParameter("cp") != null) { // 쿼리스트링에 "cp"가 존재한다면
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			
			BoardService service = new BoardService();
			
			BoardDetail detail = new BoardDetail();
			
			
			Map<String, Object> map = service.selectBoardAll(type, cp);

			req.setAttribute("map", map);
			
			String path = "/WEB-INF/views/board/boardAll.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
}
