package com.javaba.mixologyconnect.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/board/followList")
public class FollowBoardListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		try {
			int type = Integer.parseInt(req.getParameter("type"));
			
			HttpSession session = req.getSession();
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			int loginMemberNo =loginMember.getMemberNo();// 로그인한 회원의 memberNo
			
			int cp = 1;
			
			if(req.getParameter("cp") != null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			BoardService service = new BoardService();
			
			
			Map<String, Object> map = service.followBoardAll(type, cp, loginMemberNo);
			

			req.setAttribute("map", map);
			
			//System.out.println("map : " + map);
			
			
			String path = "/WEB-INF/views/board/boardAll.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req,resp);
	
	}


}

