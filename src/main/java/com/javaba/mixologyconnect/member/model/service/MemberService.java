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

	public Member login(String inputId, String inputPw) throws Exception {
		Connection conn = getConnection();
		System.out.println(inputPw);
		Member loginMember = dao.login(conn, inputId, inputPw);		
		close(conn);
		return loginMember;
	}

	/**
	 * 아이디 중복 검사
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String memberId) throws Exception{
		Connection conn = getConnection(); //DBCP에서 만들어 둔 커넥션 얻어오기

		int result = dao.idDupCheck(conn, memberId);

		close(conn);

		return result;
	}



	/**@author 이미래 
	 * 아이디 찾기 Service
	 * @param memberName
	 * @param memberTel
	 * @return result
	 * @throws Exception
	 */
	public Member searchId(String memberName, String memberTel) throws Exception {
		
		Connection conn = getConnection();
		
		Member member = dao.selectOne(conn, memberName, memberTel);
		
		close(conn);
		
		return member;
	}


	/**@author 이지영
	 * 회원정보 수정 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member mem)throws Exception {

		Connection conn= getConnection();

		int result= dao.updateMember(conn,mem);


		if(result>0) commit(conn);
		else rollback(conn);


		close(getConnection());

		return result;
	}


	/**@author 이지영
	 * 비밀번호 변경 Service 
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 * 
	 */
	public int changePw(String currentPw, String newPw, int memberNo)throws Exception {
		Connection conn = getConnection(); //DBCP에서 얻어옴

		int result = dao.changePw(conn, currentPw, newPw, memberNo);		

		if(result> 0)conn.commit();
		else conn.rollback();

		close(conn);

		return result;
	}

	/** 회원탈퇴 Service
	 * @author 임성수
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String memberPw) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.secession(conn, memberNo, memberPw);
		
		if(result> 0)conn.commit();
		else conn.rollback();

		close(conn);
		
		return result;
	}


	/**@author 이지영
	 * 프로필 사진 변경 service
	 * @param memberNo
	 * @param profileImage
	 * @return result
	 */
	public int updateProfileImage(int memberNo, String profileImage) throws Exception {
		Connection conn = getConnection(); //DBCP에서 얻어옴

		int result = dao.updateProfileImage(conn, memberNo, profileImage);		

		if(result> 0)conn.commit();
		else conn.rollback();

		close(conn);

		return result;
	}		
	
}
