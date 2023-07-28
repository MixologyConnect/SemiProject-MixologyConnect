package com.javaba.mixologyconnect.column.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.Pagination;
import com.javaba.mixologyconnect.column.model.dao.ColumnDAO;

public class ColumnService {
	
	private ColumnDAO dao = new ColumnDAO();

	
	
	/** 컬럼 전체 목록 
	 * @author 이미래 
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectColumnAll(int type, int cp) throws Exception{

		Connection conn = getConnection();
		
		// 게시글 제목		
		String boardTitle = dao.boardTitle(conn, type);
		
		// 게시판 게시글 수 조회  
		int listCount = dao.getListCount(conn, type);
		
		// 전체 게시글 수 +현제 페이지(cp)를 이용해 페이지네이션 객체 생성
		Pagination pagination = new Pagination(cp, listCount);
		
		// 게시글 목록 조회
		List<Board> columnList = dao.selectColumnList(conn, pagination, type);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardTitle", boardTitle);
		map.put("pagination", pagination);
		map.put("columnList", columnList);
		
		close(conn);
		
		return map;
	}

}
