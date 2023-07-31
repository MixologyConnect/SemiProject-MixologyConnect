package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;
import com.javaba.mixologyconnect.myPage.model.vo.BookMark;

@WebServlet("/myPage/bookMark")
public class BookMarkServlet extends HttpServlet {
	
	MypageService service = new MypageService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		
			HttpSession session = req.getSession();
			List<BookMark> bookMarkList = (List<BookMark>)session.getAttribute("bookMarkList");
			
			req.setAttribute("bookMarkList", bookMarkList);
			
			String path = "/WEB-INF/views/myPage/bookMark.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
			
			
			
			
		
	}
	
}
