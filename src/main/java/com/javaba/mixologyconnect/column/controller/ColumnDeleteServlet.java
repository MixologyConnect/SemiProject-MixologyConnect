package com.javaba.mixologyconnect.column.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.board.model.service.BoardService;

@WebServlet("/column/columnDelete")
public class ColumnDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			int boardNo = Integer.parseInt(req.getParameter("no"));
			
			int result = new BoardService().boardDelete(boardNo);
			
			HttpSession session = req.getSession();
			
			String path = null;
			String message = null;
			
			if(result > 0) {
				message = "게시글이 삭제되었습니다.";
				path = "columnList?type=" +type;
			}else {
				message = "게시글 삭제 실패";
				path = req.getHeader("referer");
			}
			
			session.setAttribute("message", message);
			resp.sendRedirect(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
