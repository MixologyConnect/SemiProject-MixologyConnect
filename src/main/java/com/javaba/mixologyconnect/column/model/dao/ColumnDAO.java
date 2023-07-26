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
import com.javaba.mixologyconnect.column.model.vo.Column;

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
	

	/** 컬럼 전체 목록 DAO
	 * @author 이미래 
	 * @param conn
	 * @param type
	 * @return map
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
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination, int type) throws Exception {
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
		
			String sql = prop.getProperty("selectBoardList");
			
			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() - 1;

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			
				Column column = new Column();
				
			
				
				
				
				
			}
			
			
			
		} finally {

		}
		
		

		return boardList;
	}
	

}
