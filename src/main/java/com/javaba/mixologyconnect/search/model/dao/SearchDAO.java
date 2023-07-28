package com.javaba.mixologyconnect.search.model.dao;

import java.io.Closeable;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;
import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

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
	public List<Cocktail> selectCocktailList(Connection conn, String keyWord) throws Exception{
		
		List<Cocktail> cocktailList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectCocktailList"); 
			
			pstmt = conn.prepareStatement(sql);
			
			String searchPattern = "%" + keyWord + "%";
			pstmt.setString(1, searchPattern);
			pstmt.setString(2, searchPattern);
			pstmt.setString(3, searchPattern);
			
			rs= pstmt.executeQuery();
			
			while (rs.next()) {
				Cocktail cocktail = new Cocktail();
				
				cocktail.setCocktailNo(rs.getInt("CKTL_NO"));
				cocktail.setCocktailName(rs.getString("CKTL_NM"));
				cocktail.setCocktailContent(rs.getString("CKTL_CONTENT"));
				cocktail.setAlcohol(rs.getString("ACL_LEVEL").charAt(0));
				cocktail.setSugar(rs.getString("SGR_LEVEL").charAt(0));
				cocktail.setImagePath(rs.getString("IMG_PATH"));

				cocktailList.add(cocktail);
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return cocktailList;
	}
	


}
