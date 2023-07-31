package com.javaba.mixologyconnect.column.model.dao;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.board.model.dao.BoardDAO;
import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.Pagination;


public class ColumnDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ColumnDAO() {
		
		try {
			prop = new Properties();
			
			String filePath = ColumnDAO.class.getResource("/com/javaba/mixologyconnect/sql/column-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/** 컬럼 제목 DAO
	 * @author 이미래 
	 * @param conn
	 * @param type
	 * @return columnTitle
	 * @throws Exception
	 */
	public String boardTitle(Connection conn, int type) throws Exception {

		String boardTitle = null;
		
		try {
			String sql = prop.getProperty("selectColumnAll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,  type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardTitle = rs.getString(1);
			}
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardTitle;
	}

	/** 게시글 수 조회 DAO
	 * @author 이미래
	 * @param conn
	 * @param type
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int type) throws Exception {

		int listCount =0;
		
		try {
		
			String sql = prop.getProperty("getListCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
			
		} finally {

			close(rs);
			close(pstmt);
		}
		
		
		
		return listCount;
	}




	/** 컬럼 목록 조회 DAO
	 * @author 이미래 
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return columnList
	 * @throws Exception
	 */
	public List<Board> selectColumnList(Connection conn, Pagination pagination, int type) throws Exception {
		List<Board> columnList = new ArrayList<Board>();
		
		try {
		
			String sql = prop.getProperty("selectColumnList");
			
			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() - 2;

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board column = new Board();
				
				column.setThumbnail(rs.getString("IMG_RENAME"));
				column.setBoardTitle(rs.getString("BOARD_TITLE"));
				column.setMemberName(rs.getString("MEMBER_NM"));
				
				columnList.add(column);
	
			
				
			}
			
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		

		return columnList;
	}

	/** @author 이미래 
	 * 검색 조건 만족하는 게시글 수 조회 DAO
	 * @param conn
	 * @param type
	 * @param condition
	 * @return listCount
	 * @throws Exception
	 */
	public int searchListCount(Connection conn, int type, String condition) throws Exception {
		
		int listCount = 0;
		
		try {
		
			String sql = prop.getProperty("searchListCount") +condition;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}

	/** @author 이미래
	 * 검색 결과 목록 조회 
	 * @param conn
	 * @param pagination
	 * @param type
	 * @param condition
	 * @return columnList
	 * @throws Exception
	 */
	public List<Board> searchColumnList(Connection conn, Pagination pagination, int type, String condition) throws Exception{
		
		List<Board> columnList = new ArrayList();
		
		try {
			
			String sql = prop.getProperty("searchColumnList1")
					   + condition	
					   + prop.getProperty("searchColumnList2");
			
			// BETWENN 구문에 들어갈 범위 계산
			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit()+1;
			int end = start + pagination.getLimit()-2;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board column = new Board();
				
				column.setThumbnail(rs.getString("IMG_RENAME"));
				column.setBoardTitle(rs.getString("BOARD_TITLE"));
				column.setMemberName(rs.getString("MEMBER_NM"));
				
				columnList.add(column);
	
			}
			
			
			
			
		} finally {
			close(rs);
			close(pstmt);

		}
		
		return columnList;
	}
	

}
