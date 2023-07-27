package com.javaba.mixologyconnect.column.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.column.model.service.ColumnService;

@WebServlet("/column/columnAll")
public class columnAllServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			int cp =1;
			
			if(req.getParameter("cp") != null) { // 쿼리스트링에 "cp"가 존재한다면
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			
			ColumnService service = new ColumnService();
			
			// 게시판 이름, 페이지네이션 객체, 게시글 리스트를 한번에 반환하는 Service 호출
			Map<String, Object> map = service.selectColumnAll(type, cp);
			
			req.setAttribute("map", map);
			
			System.out.println(map);
			
			
			String path = "/WEB-INF/views/column/columnAll.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}