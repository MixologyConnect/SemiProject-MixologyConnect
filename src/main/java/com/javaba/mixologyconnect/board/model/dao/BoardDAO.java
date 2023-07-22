package com.javaba.mixologyconnect.board.model.dao;


import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.Pagination;


public class BoardDAO {

	 private Statement stmt;
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   
	   private Properties prop;
	   
	   public BoardDAO(){
	      
	      try {
	         prop = new Properties();
	         
	         String filePath = BoardDAO.class.getResource("/com/javaba/mixologyconnect/sql/board-sql.xml").getPath();
	         
	         prop.loadFromXML(new FileInputStream(filePath));
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	/** 게시글 제목 조회
	 * @param conn
	 * @param type
	 * @return boardTitle
	 * @throws Exception
	 */
	public String boardTitle(Connection conn, int type) throws Exception{
		
		String boardTitle = null;
		
		try {
			
			String sql = prop.getProperty("selectBoardAll");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardTitle = rs.getString(1);
			}
			
			System.out.println(rs);
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		System.out.println("게시글 제목을 얻으로 다오 왔어요");
		System.out.println(boardTitle);
		return boardTitle;
	}

	/** 게시글 수 조회
	 * @param conn
	 * @param type
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int type) throws Exception{
		int listCount = 0;
		
	try {

		String sql = prop.getProperty("getListCount");
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, type);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			listCount = rs.getInt(1);
		}
		
		
	}finally {
		close(rs);
		close(pstmt);
		
	}
		
		
		return listCount;
	}

	/** 게시글 목록 조회
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return boardList
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination, int type) throws Exception {
		
		 List<Board> boardList = new ArrayList<Board>();   
		
		try {
			
			String sql = prop.getProperty("selectBoardList");
			
			pstmt = conn.prepareStatement(sql);
			
			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
	         int end = start + pagination.getLimit() - 1;
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setInt(1, type);
	         pstmt.setInt(2, start);
	         pstmt.setInt(3, end);
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            Board board = new Board(); 
	            
	            board.setBoardNo(rs.getInt("BOARD_NO"));
	            board.setBoardTitle(rs.getString("BOARD_TITLE"));
	            board.setMemberName(rs.getString("MEMBER_NM"));
	            board.setCreateDate(rs.getString("BOARD_DT"));
	            board.setReadCount(rs.getInt("READ_COUNT"));
	            
	            boardList.add(board);
			
	            System.out.println("다오왔다");
	         }
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return boardList;
	}
	   
	   
	   
	   
	   
	   
}
