package com.javaba.mixologyconnect.cocktail.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.google.gson.JsonElement;
import com.javaba.mixologyconnect.cocktail.model.dao.CocktailDAO;
import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;
import com.javaba.mixologyconnect.cocktail.model.vo.CocktailThumbnail;

public class CocktailService {

	private CocktailDAO dao = new CocktailDAO();

	public Cocktail selectOne(int no) throws Exception {
		Connection conn = getConnection();
		Cocktail cocktail = dao.selectOne(conn, no);
		close(conn);
		return cocktail;
	}

	public List<CocktailThumbnail> selectThumbnails(int no) throws Exception {
		Connection conn = getConnection();
		List<CocktailThumbnail> thumbnails = dao.selectThumbnails(conn, no);
		close(conn);
		return thumbnails;
	}

	public List<CocktailThumbnail> filterThumbnails(String ingredients, String alcohol, String sugar) throws Exception {
		Connection conn = getConnection();
		List<CocktailThumbnail> thumbnails = dao.filterThumbnails(conn, ingredients, alcohol, sugar);
		close(conn);
		return thumbnails;
	}

}
