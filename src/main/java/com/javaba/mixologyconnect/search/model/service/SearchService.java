package com.javaba.mixologyconnect.search.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> searchAllList(String query) throws Exception{
		
		Connection conn = getConnection();
		// 1. 칵테일 검색
		List<Cocktail> cocktailList = dao.selectCocktailList(conn,query);
		
		// 2. 커뮤니티 검색
	
		// 3. 컬럼검색
		
		Map<String, Object> map = new HashMap<>();
		map.put("cocktailList", cocktailList);
		return map;
		
	}

}
