package com.javaba.mixologyconnect.chat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.chat.model.service.ChatService;

@WebServlet("/chat/send")
public class SendChatServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ChatService service = new ChatService();

		try {
			new Gson().toJson(service.sendMessage(Integer.parseInt(req.getParameter("sender")),
							  					  req.getParameter("message")),
							  resp.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
