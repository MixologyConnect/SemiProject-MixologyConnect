package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.member.model.vo.Member;
import com.javaba.mixologyconnect.myPage.model.service.MypageService;

@WebServlet("/myPage/deleteBookmark")
public class BookMarkCheckboxServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			Member loginMember =(Member) session.getAttribute("loginMember");
			
			
			
			MypageService service = new MypageService();
			
			String [] checkArr = req.getParameterValues("result");
			System.out.println("배열 길이 : " + checkArr.length);
			
			int result = service.deleteBookmark(checkArr,loginMember);
			
			resp.getWriter().print(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
