package com.javaba.mixologyconnect.cocktail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.cocktail.model.service.CocktailService;
import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;

@WebServlet("/cocktail/detail")
public class CocktailDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CocktailService service = new CocktailService();

		try {
			Cocktail cocktail = service.selectOne(Integer.parseInt(req.getParameter("no")));
			req.setAttribute("cocktail", cocktail);
			System.out.println(cocktail);
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/views/cocktail/cocktailDetail.jsp").forward(req, resp);
	}

}
