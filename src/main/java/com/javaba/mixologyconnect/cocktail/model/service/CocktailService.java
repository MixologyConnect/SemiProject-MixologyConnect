package com.javaba.mixologyconnect.cocktail.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.sql.Connection;

import com.javaba.mixologyconnect.cocktail.model.dao.CocktailDAO;
import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;

public class CocktailService {

	private CocktailDAO dao = new CocktailDAO();

	public Cocktail selectOne(int no) throws Exception {

		Connection conn = getConnection();

		Cocktail cocktail = dao.selectOne(conn, no);

		close(conn);

		return cocktail;
	}

}
