package com.javaba.mixologyconnect.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.Board;

@WebServlet("/board/Top4Board")
public class BoardTop4 extends HttpServlet {
	
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			BoardService service = new BoardService();

			List<Board> Top4Board = service.selectTop4();

			System.out.println("ASDasd : " + Top4Board);

			new Gson().toJson(Top4Board, resp.getWriter());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
