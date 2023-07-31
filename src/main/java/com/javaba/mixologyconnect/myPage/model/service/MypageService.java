package com.javaba.mixologyconnect.myPage.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.Pagination;
import com.javaba.mixologyconnect.member.model.vo.Member;
import com.javaba.mixologyconnect.myPage.model.dao.MypageDAO;
import com.javaba.mixologyconnect.myPage.model.vo.BookMark;

public class MypageService {
	
	MypageDAO dao = new MypageDAO();

		/** 마이페이지 나의 게시글 수 조회
		 * @param cp
		 * @param loginMember
		 * @return map
		 * @throws Exception
		 */
		public Map<String, Object> selectMypageList(int cp, Member loginMember) throws Exception{
			
			Connection conn = getConnection();



			// 2-1) 특정 게시판 전체 게시글 수 조회 DAO 호출
			int listCount = dao.MyPageListCount(conn, loginMember);
			System.out.println(listCount);

			// 2-2) 전체 게시글 수 + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
			Pagination pagination = new Pagination(cp, listCount);


			// 3) 게시글 목록 조회
			List<Board> boardList = dao.MyPageBoardCount( conn, pagination, loginMember);

			// 4) Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장 
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("pagination", pagination);
			map.put("boardList", boardList);

			close(conn);


			return map;	// Map 객체 반환 
		}

		/** 북마크 조회 Service
		 * @param boardNo
		 * @return board
		 * @throws Exception
		 */
		public BookMark bookMarkList(int boardNo) throws Exception {
			
			Connection conn = getConnection();
			
			BookMark bookMark = dao.bookMarkList(conn, boardNo);
			
			close(conn);
			
			
			return bookMark;
		}
		
		

	

}
