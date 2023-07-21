package com.javaba.mixologyconnect.board.model.service;
import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.Map;

import com.javaba.mixologyconnect.board.model.dao.BoardDAO;

public class BoardService {

	 private BoardDAO dao = new BoardDAO(); 
	
	public Map<String, Object> selectBoardAll(int type, int cp) throws Exception{
		
		Connection conn = getConnection();
		
		// 게시글 제목
		String boardTitle = dao.boardTitle(conn, type);
		
		
		
		return null;
	}


}
