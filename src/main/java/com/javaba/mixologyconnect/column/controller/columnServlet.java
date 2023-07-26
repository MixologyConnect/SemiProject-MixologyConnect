package com.javaba.mixologyconnect.column.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/column/column")
public class columnServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
<<<<<<< HEAD:src/main/java/com/javaba/mixologyconnect/column/controller/columnServlet.java
			String path = "/WEB-INF/views/column/column.jsp";
=======
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			
			
			
			
			
			
			
			
			
			
			
			String path = "/WEB-INF/views/column/columnAll.jsp";
>>>>>>> 4f39bc820fd03ae55a8c3aaa9b9a8385956a3d1d:src/main/java/com/javaba/mixologyconnect/column/columnAllServlet.java
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}