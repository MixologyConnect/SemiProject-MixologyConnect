package com.javaba.mixologyconnect.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.board.model.service.BoardService;

@WebServlet("/manager/manager/boardDelete")
public class managerBaordDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String boardTitle = req.getParameter("boardTitle");

		try {

			BoardService service = new BoardService();

			int result = service.managerBoardDelete(boardTitle);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}