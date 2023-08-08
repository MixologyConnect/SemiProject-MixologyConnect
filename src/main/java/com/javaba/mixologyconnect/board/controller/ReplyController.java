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
import com.javaba.mixologyconnect.common.Util;
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

				int boardNo = Integer.parseInt(req.getParameter("boardNo"));

				List<Reply> rList = service.selectReplyList(boardNo);
				

				new Gson().toJson(rList, resp.getWriter());
			}
			
			if(command.equals("insert")) {
				
				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				String replyContent = req.getParameter("replyContent");
				
				Reply reply = new Reply();
				
				reply.setMemberNo(memberNo);
				reply.setBoardNo(boardNo);
				reply.setReplyContent(replyContent);
				
				int result = service.insertReply(reply);
				
				resp.getWriter().print(result);
				
				
			}
			
			if(command.equals("delete")) {
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				int result = service.deleteReply(replyNo);
				resp.getWriter().print(result);
			}
			
			if(command.equals("update")) {
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				String replyContent = req.getParameter("replyContent");
				
				replyContent = Util.XSSHandling(replyContent);
				replyContent = Util.newLineHandling(replyContent);
				
				int result = service.updateReply(replyNo, replyContent);
				resp.getWriter().print(result);
				
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
