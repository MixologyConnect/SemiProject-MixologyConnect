package com.javaba.mixologyconnect.search.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;

public class SearchDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public SearchDAO() {
		try {
			prop = new Properties();
			String filePath = SearchDAO.class.getResource("/com/javaba/mixologyconnect/sql/search-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**검색 결과에 따른 칵테일 조회
	 * @author 이지영
	 * @param conn
	 * @param query
	 * @return cocktailList
	 */
	public List<Cocktail> selectCocktailList(Connection conn, String query) throws Exception{
		
		List<Cocktail> cocktailList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectCocktailList"); 
			
			pstmt = conn.prepareStatement(sql);
			
			
		}finally {
			
		}
		return null;
	}
	


}
