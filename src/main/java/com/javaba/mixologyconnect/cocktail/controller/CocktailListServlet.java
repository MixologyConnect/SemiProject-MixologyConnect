package com.javaba.mixologyconnect.cocktail.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.cocktail.model.service.CocktailService;
import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;
import com.javaba.mixologyconnect.cocktail.model.vo.Ingredient;
import com.javaba.mixologyconnect.cocktail.model.vo.IngredientType;

@WebServlet("/cocktail/list")
public class CocktailListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(Ingredient.maps);
		System.out.println(IngredientType.maps);
		try {
			CocktailService service = new CocktailService();
//			List<Cocktail> cocktails = service.selectCocktailList();
			req.getRequestDispatcher("/WEB-INF/views/cocktail/cocktailList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
