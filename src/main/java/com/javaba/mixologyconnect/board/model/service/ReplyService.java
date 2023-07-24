package com.javaba.mixologyconnect.board.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.javaba.mixologyconnect.board.model.dao.ReplyDAO;
import com.javaba.mixologyconnect.board.model.vo.Reply;

public class ReplyService {
	
	private ReplyDAO dao = new ReplyDAO();

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Reply> rList = dao.selectReplyList(conn, boardNo);
		
		return rList;
	}

}
