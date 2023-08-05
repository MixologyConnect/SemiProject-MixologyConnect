package com.javaba.mixologyconnect.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.BoardDetail;

@WebServlet("/manager/notice")
public class noticeGoservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String mode = req.getParameter("mode");
			
			
			if(mode.equals("update")) {
				

				BoardDetail detail = new BoardService().selectNoticeDetail();
				
				detail.setBoardContent(detail.getBoardContent().replaceAll("<br>", "\n"));
				
				req.setAttribute("detail", detail);
			}
			
			String path = "/WEB-INF/views/manager/notice.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}