package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;
import com.javaba.mixologyconnect.myPage.model.vo.BookMark;

@WebServlet("/myPage/bookMarkInsert")
public class BookMarkInsertServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MypageService service = new MypageService();
		
		try {
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			BookMark bk = service.selectInfo(boardNo);
			
			
			
			int result = service.bookMarkInsert(bk);
			
			new Gson().toJson(result , resp.getWriter());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

}
