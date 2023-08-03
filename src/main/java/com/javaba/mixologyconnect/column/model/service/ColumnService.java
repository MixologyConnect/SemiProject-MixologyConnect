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


	/**@author 이미래
	 * 컬럼 전체 보기 Service
	 * @param type
	 * @param cp
	 * @param title
	 * @param columnquery
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectColumnAll(int type, int cp, String title, String columnquery) throws Exception{
		
		Connection conn = getConnection();
		
		// 게시판 이름 조회 DAO
		String boardTitle = dao.boardTitle(conn,  type);
		
		// SQL 조거절 추가될 구문 가공
		String condition = null; // 조건
		
		switch(title) {
		case "title" :condition = "AND BOARD_TITLE LIKE '%" + columnquery + "%' "; break;
		case "content" :condition = "AND BOARD_CONTENT LIKE '%" + columnquery + "%' "; break;
		case "TC" :condition = "AND (BOARD_TITLE LIKE '%" + columnquery + "%' OR BOARD_CONTENT LIKE '%" + columnquery +"%') "; break;
		
		}
		
		// 조건을 만족하는 게시글 수 조회
		int listCount = dao.searchListCount(conn, type, condition);
		
		// listCount + cp 페이지 이셩 객체 생성
		Pagination pagination = new Pagination(cp, listCount);
		
		// 특정게시판 조건 만족하는 게시글 목록 조회
		List<Board> columnList = dao.searchColumnList(conn, pagination, type, condition);
		
		// map에 모아서 반
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardName", boardTitle);
		map.put("pagination", pagination);
		map.put("columnList", columnList);
		
		close(conn);
		
		return map;
	}

}
