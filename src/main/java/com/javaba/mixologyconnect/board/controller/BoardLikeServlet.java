package com.javaba.mixologyconnect.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.Board;

@WebServlet("/board/like")
public class BoardLikeServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			
			int memberNo = Integer.parseInt(req.getParameter("loginMemberNo"));
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			int likeCheck = Integer.parseInt(req.getParameter("likeCheck"));
			
			BoardService service=new BoardService();
			
			Map<String, Integer> like = service.likeSelect(memberNo, boardNo, likeCheck);
			
			new Gson().toJson(like, resp.getWriter());
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
		
		
	}

}
