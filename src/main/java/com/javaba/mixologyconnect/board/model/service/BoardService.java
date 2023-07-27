package com.javaba.mixologyconnect.board.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaba.mixologyconnect.board.model.dao.BoardDAO;
import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.BoardDetail;
import com.javaba.mixologyconnect.board.model.vo.BoardImage;
import com.javaba.mixologyconnect.board.model.vo.Pagination;

public class BoardService {
	private BoardDAO dao = new BoardDAO();

	/**
	 * 게시글 목록 조회
	 * 
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardAll(int type, int cp) throws Exception {

		Connection conn = getConnection();
		
		// 게시글 제목
		String boardTitle = dao.boardTitle(conn, type);
		

		int listCount = dao.getListCount(conn, type);

		// 2-2. 전체 게시글 수 + 현재 페이지 (cp)를 이용해 페이지네이션 객체 생성
		Pagination pagination = new Pagination(cp, listCount);

		// 3. 게시글 목록 조회
		List<Board> boardList = dao.selectBoardList(conn, pagination, type);

		// 4. Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boardName", boardTitle);
		map.put("pagination", pagination);
		map.put("boardList", boardList);

		close(conn);
		return map;
	}

	/**
	 * 게시글 상세 조회
	 * 
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int boardNo) throws Exception {

		System.out.println("게시글 상세 조회 서비스 왔다");
		Connection conn = getConnection();

		BoardDetail detail = dao.selectBoardDetail(conn, boardNo);

		if (detail != null) { 

			List<BoardImage> imageList = dao.selectImageList(conn, boardNo);


			detail.setImageList(imageList);

			close(conn);
			
			System.out.println("게시글 상세 조회 서비스 나간다");

		}
		return detail;

	}

}
