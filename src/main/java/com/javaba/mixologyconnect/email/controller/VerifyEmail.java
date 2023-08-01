package com.javaba.mixologyconnect.email.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.email.model.service.EmailService;

@WebServlet("/email/verify")
public class VerifyEmail extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		try {
			String vrfCode = EmailService.sendEmail((String)req.getParameter("email"), (String)req.getParameter("serv"));
			session.setAttribute("vrfCode", vrfCode);
		} catch(Exception e) {
			
		}

	}

}
