package com.javaba.mixologyconnect.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.BoardDetail;

@WebServlet("/manager/noticeModal")
public class noticeModalServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			BoardService service = new BoardService();
			
			BoardDetail detail =  service.searchNotice();
			
			detail.setBoardContent(detail.getBoardContent().replaceAll("<br>", "\n"));

			new Gson().toJson(detail, resp.getWriter());
			
		} catch (Exception e) {
			
		}
	}
}
