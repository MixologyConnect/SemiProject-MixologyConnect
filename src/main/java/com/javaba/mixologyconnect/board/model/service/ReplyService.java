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

	/** 댓글 등록
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.insertReply(conn, reply);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}

}
