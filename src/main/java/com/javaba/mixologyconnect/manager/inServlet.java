//package com.javaba.mixologyconnect.manager;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/manager/noticeModal")
//public class inServlet extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try {
//			String path = "/WEB-INF/views/manager/noticeModal.jsp";
//
//			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//			dispatcher.forward(req, resp);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}