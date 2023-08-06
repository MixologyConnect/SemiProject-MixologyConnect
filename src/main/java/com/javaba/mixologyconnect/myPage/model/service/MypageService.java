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

	

	
	

		

		
		
		

		/** 북마크 게시글정보 얻어오기 Service
		 * @param boardNo
		 * @return memberNo
		 * @throws Exception
		 */
		public BookMark selectInfo(int boardNo)throws Exception {
			Connection conn = getConnection();
			
			BookMark bk = dao.selectInfo(conn, boardNo);
			
			close(conn);
			
			return bk;
		}

		
		

		
		/** 북마크 삽입 Service
		 * @param memberNo
		 * @param boardNo
		 * @return
		 */
		public int bookMarkInsert(BookMark bk, Member loginMember) throws Exception {
			Connection conn= getConnection();
			
			int result = dao.bookMarkInsert(conn, bk, loginMember);
			
			if(result>0) {conn.commit();}
			else				{conn.rollback();}
			
			close(conn);
			
			return result;
		}
		






		/** 북마크 게시글 목록 조회 Service
		 * @param cp
		 * @return
		 */
		public Map<String, Object> selectbookMarkList(int cp, Member loginMember)throws Exception {
			Connection conn = getConnection();
			
			// 2-1) 특정 게시판 전체 게시글 수 조회 DAO 호출
//			int listCount = dao.bookMarkListCount(conn, loginMember);
			int listCount = dao.bookMarkListCountB(conn, loginMember);

			// 2-2) 전체 게시글 수 + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
			Pagination pagination = new Pagination(cp, listCount);


			// 3) 게시글 목록 조회
//			List<BookMark> bookMarkList = dao.bookMarkList( conn, pagination, loginMember);
			List<Board> bookMarkList = dao.bookMarkList( conn, pagination, loginMember);

			// 4) Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장 
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("pagination", pagination);
			map.put("bookMarkList", bookMarkList);

			close(conn);


			return map;	// Map 객체 반환 
		}






		/** 북마크 버튼 이미지 
		 * @param boardNo
		 * @param loginMember
		 * @return result
		 * @throws Exception
		 */
		public int existNo(int boardNo, Member loginMember)throws Exception {
			
			Connection conn = getConnection();
			
			int result = dao.existNo(conn, boardNo, loginMember);
			
			close(conn);
			
			return result;
		}





		/** 북마크 해제 Service
		 * @param loginMember
		 * @return result
		 * @throws Exception
		 */
		public int delete(int boardNo, Member loginMember)throws Exception {
			Connection conn = getConnection();
			
			int result = dao.delete(conn, boardNo, loginMember);
			
			if(result>0) {conn.commit();}
			else				{conn.rollback();}
			
			close(conn);
			
			return result;
		}












		/** 마이페이지 게시글 삭제 Service
		 * @param arr
		 * @return result
		 * @throws Exception
		 */
		public int deletePost(String[] arr) throws Exception{
			
			Connection conn = getConnection();
			
			String condition = null;	// 조건
		
			
			System.out.println("service 배열 길이 : " + arr.length);
			
			for(int i=0; i<arr.length; i++) {
				
				switch(arr.length) {
				case 1 : condition = "(" +  arr[0] +  ")"; break;
				case 2 : condition = "(" +  arr[0] + "," + arr[1]  +  ")"; break;
				case 3 : condition = "(" +  arr[0] + "," + arr[1] + "," + arr[2] +  ")"; break;
				case 4 : condition = "(" +  arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] +  ")"; break;
				case 5 : condition = "(" +  arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]  + ")"; break;
				case 6 : condition = "(" +  arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]  + "," + arr[5] +  ")"; break;
				case 7 : condition = "(" +  arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]  + "," + arr[5] + "," + arr[6] +  ")"; break;
				case 8 : condition = "(" +  arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]  + "," + arr[5] + "," + arr[6] + "," + arr[7] +  ")"; break;
				case 9 : condition = "(" +  arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]  + "," + arr[5] + "," + arr[6] + "," + arr[7] + "," + arr[8] +  ")"; break;
				case 10 : condition = "(" +  arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]  + "," + arr[5] + "," + arr[6] + "," + arr[7] + "," + arr[8] + "," + arr[9] +  ")"; break;
				}
			}
			
			
			int result = dao.deletePost(conn, arr, condition);
			System.out.println(result);
			
			if(result > 0) {conn.commit();}
			else					{conn.rollback();}
			
			close(conn);
			
			
			
			return result;
		}






		/** 북마크 게시글 정보 얻어오기 Service Board 버전
		 * @param boardNo
		 * @return board
		 * @throws Exception
		 */
		public Board selectInfoB(int boardNo) throws Exception{
			
			Connection conn = getConnection();
			
			Board board = dao.selectInfoB(conn, boardNo);
			
			close(conn);
			
			return board;
		}









		/** 북마크 삽입 Service Board버전
		 * @param board
		 * @param loginMember
		 * @return result
		 * @throws Exception
		 */
		public int bookMarkInsertB(int boardNo, Member loginMember)throws Exception {
			Connection conn = getConnection();
			
			int result = dao.bookMarkInsertB(conn, boardNo, loginMember);
			
			if(result>0) {conn.commit();}
			else				{conn.rollback();}
			
			close(conn);
			
			return result;
			
			
		}






		/** 북마크 체크박스 삭제 Service
		 * @param result
		 * @return result
		 * @throws Exception
		 */
		public int deleteBookmark(String[] checkArr, Member loginMember)throws Exception {
			Connection conn = getConnection();
			
			String condition = null;
			
			
			for(int i=0; i<checkArr.length; i++) {
				
				switch(checkArr.length) {
				case 1 : condition = "(" +  checkArr[0] +  ")"; break;
				case 2 : condition = "(" +  checkArr[0] + "," + checkArr[1]  +  ")"; break;
				case 3 : condition = "(" +  checkArr[0] + "," + checkArr[1]  + "," + checkArr[2] +  ")"; break;
				case 4 : condition ="(" +  checkArr[0] + "," + checkArr[1]  + "," + checkArr[2] + "," + checkArr[3] + ")"; break;
				case 5 : condition = "(" +  checkArr[0] + "," + checkArr[1]  + "," + checkArr[2] + "," + checkArr[3] +"," + checkArr[4] + ")"; break;
				case 6 : condition ="(" +  checkArr[0] + "," + checkArr[1]  + "," + checkArr[2] + "," + checkArr[3] +"," + checkArr[4] + "," + checkArr[5] + ")"; break;
				case 7 : condition = "(" +  checkArr[0] + "," + checkArr[1]  + "," + checkArr[2] + "," + checkArr[3] +"," + checkArr[4] + "," + checkArr[5] + "," + checkArr[6] + ")"; break;
				case 8 : condition =  "(" +  checkArr[0] + "," + checkArr[1]  + "," + checkArr[2] + "," + checkArr[3] +"," + checkArr[4] + "," + checkArr[5] + "," + checkArr[6] + "," + checkArr[7] + ")"; break;
				case 9 : condition = "(" +  checkArr[0] + "," + checkArr[1]  + "," + checkArr[2] + "," + checkArr[3] +"," + checkArr[4] + "," + checkArr[5] + "," + checkArr[6] + "," + checkArr[7] + "," + checkArr[8] + ")"; break;
				case 10 : condition ="(" +  checkArr[0] + "," + checkArr[1]  + "," + checkArr[2] + "," + checkArr[3] +"," + checkArr[4] + "," + checkArr[5] + "," + checkArr[6] + "," + checkArr[7] + "," + checkArr[8] + "," + checkArr[9] + ")"; break;
				}
			}
			
			int result = dao.deleteBookmark(conn, checkArr, loginMember, condition);
			
			if(result > 0) {conn.commit();}
			else 					{conn.rollback();}
			
			close(conn);
			
			
			return result;
		}





		/** 북마크 검색 리스트 Service
		 * @param cp
		 * @param key
		 * @param query
		 * @return map
		 * @throws Exception
		 */
		public Map<String, Object> searchBoardList(Member loginMember, int cp, String key, String query) throws Exception{
			Connection conn = getConnection();
			
			// sql조건절에 추가될 구문(key, query 사용)
			String condition = null;
			
			switch(key) {
			case "t" : condition = " AND BOARD_TITLE LIKE '%"+query +"%' "; break;
			case "c" : condition = " AND BOARD_CONTENT LIKE '%"+query +"%' "; break;
			case "tc" : condition = " AND (BOARD_TITLE LIKE '%"+query +"%' OR BOARD_CONTENT LIKE '%" + query + "%') "; break;
			case "w" : condition = " AND MEMBER_NM LIKE '%"+query +"%' "; break;
			}
			
			// 특정 게시판에서 조건을 만족하는 게시글 수 조회
			int listCount = dao.searchListCount(conn, loginMember, condition);
			
			//  listCount + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
			Pagination pagination = new Pagination(cp, listCount);
			
			// 특정 게시판에서 조건을 만족하는 게시글 목록 조회
			List<Board> bookMarkList = dao.searchList(conn, loginMember, pagination, condition);
			
			// 결과값을 하나의 Map에 모아서 반환
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pagination", pagination);
			map.put("bookMarkList", bookMarkList);
			
			close(conn);
			
			
			
			
			return map;
		}











		public Map<String, Object> selectuserPageList(int cp, int memberNo) throws Exception {

			Connection conn = getConnection();

			// 2-1) 특정 게시판 전체 게시글 수 조회 DAO 호출
			int listCount = dao.userPageListCount(conn, memberNo);
			System.out.println(listCount);

			// 2-2) 전체 게시글 수 + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
			Pagination pagination = new Pagination(cp, listCount);

			// 3) 게시글 목록 조회
			List<Board> boardList = dao.userPageBoardCount(conn, pagination, memberNo);
			
			Member member = dao.selectMember(conn, memberNo);

			// 4) Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("pagination", pagination);
			map.put("member", member);
			map.put("boardList", boardList);

			close(conn);

			return map; // Map 객체 반환
		}

	}

