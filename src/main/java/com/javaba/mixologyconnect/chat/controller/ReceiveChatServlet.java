package com.javaba.mixologyconnect.chat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.chat.model.service.ChatService;

@WebServlet("chat/receive")
public class ReceiveChatServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		ChatService service = new ChatService();

		try {
			new Gson().toJson(service.receiveMessages(Integer.parseInt(req.getParameter("sender")), session.getCreationTime()), resp.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
