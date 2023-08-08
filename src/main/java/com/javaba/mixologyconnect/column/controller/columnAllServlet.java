package com.javaba.mixologyconnect.column.controller;

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

import com.google.gson.Gson;
import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.column.model.service.ColumnService;

@WebServlet("/column/columnList")
public class columnAllServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 페이지네이션
			int type = Integer.parseInt(req.getParameter("type"));

			int cp =1;

			if(req.getParameter("cp") != null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}


			ColumnService service = new ColumnService();

			// 게시판 이름, 페이지네이션 객체, 게시글 리스트를 한번에 반환하는 Service 호출
			Map<String, Object> map = null;

			if(req.getParameter("title") == null) {
				map = service.selectColumnAll(type, cp);

				
			}else {

				String title = req.getParameter("title");
				String columnquery = req.getParameter("columnquery");

				map = service.selectColumnAll(type, cp, title, columnquery);




			}



			//			System.out.println(map);

			req.setAttribute("map", map);

			String path = "/WEB-INF/views/column/columnAll.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);



			



		} catch (Exception e) {
			e.printStackTrace();
		}


	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			ColumnService service = new ColumnService();
			
			List<Board> columnList = new ArrayList<>();
			columnList = service.selectColumnList(3);
			
			System.out.println("columnList"+columnList);
			
			
			new Gson().toJson(columnList, resp.getWriter());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
	
	
	
	}

}