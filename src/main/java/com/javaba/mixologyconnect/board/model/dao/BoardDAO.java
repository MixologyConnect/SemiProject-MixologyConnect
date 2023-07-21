package com.javaba.mixologyconnect.board.model.dao;


import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


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
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return boardTitle;
	}
	   
	   
	   
	   
	   
	   
}
