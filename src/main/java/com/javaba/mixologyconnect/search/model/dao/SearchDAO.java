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

import com.javaba.mixologyconnect.board.model.vo.Board;
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

	/**
	 * 검색결과에 따른 게시글 목록 조회
	 * @param conn
	 * @param keyWord
	 * @return boardList
	 */
	public List<Board> selectboardList(Connection conn, String keyWord) throws Exception{

		List<Board> boardList = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectBoardList");

			pstmt= conn.prepareStatement(sql);

			String searchPattern = "%" + keyWord + "%";
			pstmt.setString(1, searchPattern);
			pstmt.setString(2, searchPattern);

			rs= pstmt.executeQuery();

			while(rs.next()){

				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));

				boardList.add(board);
			}


		}finally {
			close(rs);
			close(pstmt);
		}

		return boardList;


	}

	/**
	 * 검색 키워드에 맞는 컬럼 결과 조회 DAO
	 * @param conn
	 * @param keyWord
	 * @return columnList
	 * @throws Exception
	 */
	public List<Board> selectColumnList(Connection conn, String keyWord)throws Exception {
		List<Board> columnList = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectColumnList");

			pstmt= conn.prepareStatement(sql);

			String searchPattern = "%" + keyWord + "%";
			pstmt.setString(1, searchPattern);
			pstmt.setString(2, searchPattern);

			rs= pstmt.executeQuery();

			while(rs.next()){

				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));

				columnList.add(board);
			}


		}finally {
			close(rs);
			close(pstmt);
		}

		return columnList;
	}

	/**당도와 관련 있는 키워드 검색 결과 Dao
	 * 
	 * @param conn
	 * @param keyWord
	 * @return cocktailList
	 */
	public List<Cocktail> selectSweetKeyword(Connection conn, String keyWord) throws Exception{
		
		List<Cocktail> cocktailList = new  ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectSweetKeyword");
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
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
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return cocktailList;
		
	}

	/**도수와 관련된 키워드 검색 결과 조회
	 * @param conn
	 * @param keyWord
	 * @return cocktailList
	 */
	public List<Cocktail> selectHardKeyword(Connection conn, String keyWord) throws Exception{
		List<Cocktail> cocktailList = new  ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectHardKeyword");
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
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
			close(stmt);
			
		}
		return cocktailList;
	}

	/**"칵테일" 검색시 정체 칵테일 정보 조회 
	 * @param conn
	 * @param keyWord
	 * @return cocktailList
	 */
	public List<Cocktail> selectAllCktl(Connection conn, String keyWord) throws Exception{

		List<Cocktail> cocktailList = new  ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectAllCktl");
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
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
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return cocktailList;
	
	}



}
