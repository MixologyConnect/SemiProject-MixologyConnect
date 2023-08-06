package com.javaba.mixologyconnect.cocktail.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaba.mixologyconnect.cocktail.model.service.CocktailService;

@WebServlet("/cocktail/list")
public class CocktailListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			req.getRequestDispatcher("/WEB-INF/views/cocktail/cocktailList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CocktailService service = new CocktailService();

		try {
			switch (req.getParameter("mode")) {
			case "update":
				new Gson().toJson(service.selectThumbnails(Integer.parseInt(req.getParameter("no"))), resp.getWriter());
				break;
			case "search":
				new Gson().toJson(service.filterThumbnails(Arrays.deepToString(req.getParameter("ingredients").split(",")).replaceAll("[\\[\\]]", ""),
														   req.getParameter("alcohol"),
														   req.getParameter("sugar")), resp.getWriter());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
