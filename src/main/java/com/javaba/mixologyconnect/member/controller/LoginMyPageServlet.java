package com.javaba.mixologyconnect.member.controller;

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

@WebServlet("/myPage/myPage")
public class LoginMyPageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember") );

			// 쿼리스트링에 cp가 없음 --> cp = 1 고정
			int cp = 1;

			// 페이지네이션 번호 선택 시
			// 쿼리스트링에 cp가 있음 --> cp = 쿼리스트링의 cp값
			if(req.getParameter("cp") != null) { // 쿼리스트링에 "cp"가 존재한다면
				cp = Integer.parseInt(req.getParameter("cp"));
			}


			BoardService service = new BoardService();

			// 게시판 이름, 페이지네이션 객체, 게시글 리스트를 한번에 반환하는 Service 호출
			Map<String, Object> map = service.selectMypageList(cp, loginMember);

			req.setAttribute("map", map);

			System.out.println(map);

			String path = "/WEB-INF/views/myPage/myPage.jsp";

			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);


		}catch (Exception e) {
			e.printStackTrace();
		}

	}



}



