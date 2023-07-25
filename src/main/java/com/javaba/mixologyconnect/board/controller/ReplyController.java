package com.javaba.mixologyconnect.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.board.model.service.ReplyService;
import com.javaba.mixologyconnect.board.model.vo.Reply;

import com.google.gson.Gson;

@WebServlet("/reply/*")
public class ReplyController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring((contextPath + "/reply/").length());

		ReplyService service = new ReplyService();	
		
		try {
			
			if (command.equals("selectReplyList")) {

				// 파라미터를 얻어와 정수 형태로 파싱
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));

				// 댓글 목록 조회 서비스 호출 후 결과 반환 받기
				List<Reply> rList = service.selectReplyList(boardNo);
				
				System.out.println("rList :" + rList);

				// JSON 변환 + 응답
				new Gson().toJson(rList, resp.getWriter());
			}
			
			if(command.equals("insert")) {
				
				
				
				//int result = service.insertReply();
				
			}
			
			if(command.equals("delete")) {
				
			}
			
			if(command.equals("update")) {
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
	
	}
	
}
