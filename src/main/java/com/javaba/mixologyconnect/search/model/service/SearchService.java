package com.javaba.mixologyconnect.search.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.cocktail.model.vo.Cocktail;
import com.javaba.mixologyconnect.search.model.dao.SearchDAO;

public class SearchService {

	private SearchDAO dao = new SearchDAO();
	
	/**@author 이지영
	 * 검색 전체보기 목록 조회  
	 * @param query
	 * @return Map
	 * @throws Exception
	 */
	public Map<String, Object> searchAllList(String keyWord) throws Exception{
		
		Connection conn = getConnection();
		// 1. 칵테일 검색
		List<Cocktail> cocktailList =null;
		// 2. 커뮤니티 검색
		List<Board> boardList = null;
		// 3. 컬럼검색
		List<Board> columnList = null;
		
		if(keyWord.equals("달달한")|| keyWord.equals("단")|| keyWord.equals("달달")) {
			cocktailList = dao.selectSweetKeyword(conn,keyWord);
		
		}else if(keyWord.equals("높은")|| keyWord.equals("강한")) {
			cocktailList = dao.selectHardKeyword(conn,keyWord);
		
		}else {
			cocktailList = dao.selectCocktailList(conn,keyWord);
		}
		
		boardList = dao.selectboardList(conn, keyWord);
		
		columnList = dao.selectColumnList(conn, keyWord);
		
		// 4. 검색 결과 수 
		int coctailCount = cocktailList.size();
		int boardCount = boardList.size();
		int columnCount = columnList.size();
		int allCount = coctailCount+ boardCount+columnCount;
		
		int[] countArr = {coctailCount,boardCount,columnCount,allCount}; 
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("cocktailList", cocktailList);
		map.put("boardList", boardList);
		map.put("columnList", columnList);
		map.put("countArr", countArr);
		
		close(conn);
		return map;
		
	}

}
