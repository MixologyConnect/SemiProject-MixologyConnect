package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;

@WebServlet("/myPage/bookMarkInsert")
public class BookMarkInsertServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MypageService service = new MypageService();
		
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		int result = service.bookMarkInsert(boardNo);
		
		new Gson().toJson(result , resp.getWriter());
		
		
		
	}

}
