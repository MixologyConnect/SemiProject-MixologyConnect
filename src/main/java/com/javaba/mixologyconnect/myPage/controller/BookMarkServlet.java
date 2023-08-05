package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.member.model.vo.Member;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;
import com.javaba.mixologyconnect.myPage.model.vo.BookMark;

@WebServlet("/myPage/bookMark")
public class BookMarkServlet extends HttpServlet {
	
	MypageService service = new MypageService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
			
			try {
				MypageService service = new MypageService();
				
				HttpSession session = req.getSession();
				Member loginMember = (Member)(session.getAttribute("loginMember") );

				
				int cp = 1;
				if(req.getParameter("cp") != null) cp = Integer.parseInt(req.getParameter("cp"));
				
				
				Map<String, Object> map = null;
				
				if(req.getParameter("key") == null ) {
					// 일반 목록 조회
					map =service.selectbookMarkList(cp, loginMember);
				} else {
					// 검색 목록 조회
					String key = req.getParameter("key");
					String query = req.getParameter("query");
					
					map = service.searchBoardList(loginMember, cp,  key, query);
				}
				
				
				req.setAttribute("map", map);
				
				
				String path = "/WEB-INF/views/myPage/bookMark.jsp";
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				
				dispatcher.forward(req, resp);
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
			
			
			
			
		
	}
	
}
