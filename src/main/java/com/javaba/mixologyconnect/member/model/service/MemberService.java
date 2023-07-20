package com.javaba.mixologyconnect.member.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.sql.Connection;

import com.javaba.mixologyconnect.member.model.dao.MemberDAO;
import com.javaba.mixologyconnect.member.model.vo.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();

	
	
	
	/**@author 이지영
	 * 회원가입 서비스 
	 * @param mem
	 * @return result 
	 * @throws Exception
	 */
	public int signUp(Member mem)throws Exception {

		Connection conn = getConnection();
		
		int result = dao.signUp(conn, mem);
		
		//트렌젝션 처리
		if(result > 0)conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
	}
	
	
	
}
