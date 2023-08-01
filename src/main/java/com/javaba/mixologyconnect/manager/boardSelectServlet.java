package com.javaba.mixologyconnect.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/manager/manager/selectBoard")
public class boardSelectServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String boardTitle = req.getParameter("searchBoard");
		try {
			
			Board board = new Board();
			
			Member member = new Member();
			
			BoardService service = new BoardService();
			
			board = service.searchBoard(member, boardTitle);
			
			new Gson().toJson(board, resp.getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
