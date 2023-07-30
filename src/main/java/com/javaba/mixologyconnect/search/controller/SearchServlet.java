package com.javaba.mixologyconnect.search.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.search.model.service.SearchService;
import com.javaba.mixologyconnect.search.model.vo.Search;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String keyWord = req.getParameter("query");
			
			SearchService service = new SearchService();

			Map<String,Object>map = service.searchAllList(keyWord);

			req.setAttribute("map", map);

			
			String path = "/WEB-INF/views/search/searchPage.jsp";

			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
