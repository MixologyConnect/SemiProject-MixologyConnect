package com.javaba.mixologyconnect.cocktail.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;
import com.javaba.mixologyconnect.cocktail.model.vo.CocktailThumbnail;
import com.javaba.mixologyconnect.cocktail.model.vo.Ingredient;
import com.javaba.mixologyconnect.search.model.dao.SearchDAO;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

public class CocktailDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public CocktailDAO() {
		try {
			prop = new Properties();
			String filePath = SearchDAO.class.getResource("/com/javaba/mixologyconnect/sql/cocktail-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cocktail selectOne(Connection conn, int no) throws Exception {

		Cocktail cocktail = null;

		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectOne"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cocktail = new Cocktail();
				cocktail.setCocktailNo(no);
				cocktail.setCocktailName(rs.getString("CKTL_NM"));
				cocktail.setCocktailContent(rs.getString("CKTL_CONTENT"));
				cocktail.setAlcohol(rs.getString("ACL_LEVEL").charAt(0));
				cocktail.setSugar(rs.getString("SGR_LEVEL").charAt(0));
				cocktail.setDifficulty(rs.getString("DIFFICULTY").charAt(0));
				cocktail.setRecipeContent(rs.getString("RECIPE_CONTENT"));
				cocktail.setImagePath(rs.getString("IMG_PATH"));
			}
			pstmt = conn.prepareStatement(prop.getProperty("selectIngredients"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) cocktail.getRecipe().put(Ingredient.maps.get(rs.getInt("INGR_CODE") + ""),
										 			   					   rs.getString("INGR_AMOUNT"));
		} finally {
			close(pstmt);
			close(rs);
		}
		return cocktail;
	}

	public List<CocktailThumbnail> selectThumbnails(Connection conn, int no) throws Exception {
		List<CocktailThumbnail> thumbnails = new ArrayList<CocktailThumbnail>();

		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectThumbnails"));
			pstmt.setInt(1, no * 16 - 15);
			pstmt.setInt(2, no * 16);
			rs = pstmt.executeQuery();
			while (rs.next()) thumbnails.add(new CocktailThumbnail(rs.getInt("CKTL_NO"), rs.getString("CKTL_NM"), rs.getString("IMG_PATH")));
		} finally {
			close(pstmt);
			close(rs);
		}

		return thumbnails;
	}

	public List<CocktailThumbnail> filterThumbnails(Connection conn, String ingredients, String alcohol,
			String sugar) throws Exception {
		List<CocktailThumbnail> thumbnails = new ArrayList<CocktailThumbnail>();

		try {
			pstmt = conn.prepareStatement(prop.getProperty("filterThumbnails") + "WHERE INGR_CODE IN(" + ingredients + ")" + (alcohol != null ? " AND ACL_LEVEL = '" + alcohol + "'" : "") + (sugar != null ? " AND SGR_LEVEL = '" + sugar + "'" : ""));
			rs = pstmt.executeQuery();
			while (rs.next()) thumbnails.add(new CocktailThumbnail(rs.getInt("CKTL_NO"), rs.getString("CKTL_NM"), rs.getString("IMG_PATH")));
		} finally {
			close(pstmt);
			close(rs);
		}

		return thumbnails;
	}

}
