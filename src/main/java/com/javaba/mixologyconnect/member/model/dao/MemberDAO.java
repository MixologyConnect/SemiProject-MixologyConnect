package com.javaba.mixologyconnect.member.model.dao;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.nio.file.ClosedDirectoryStreamException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.javaba.mixologyconnect.member.model.vo.Member;


public class MemberDAO {

	private Statement stmt; 
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	// 기본 생성자
	public MemberDAO() {

		try {

			prop = new Properties();

			String filePath =  MemberDAO.class.getResource("/com/javaba/mixologyconnect/sql/member-sql.xml").getPath(); 

			prop.loadFromXML(new FileInputStream(filePath));

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**@author 이지영
	 * 회원가입 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member mem)throws Exception {
		int result = 0;

		try {
			String sql =prop.getProperty("signUp");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberTel());
			pstmt.setString(4, mem.getMemberName());
			pstmt.setString(5, mem.getMemberAddress());
			pstmt.setString(6, mem.getMemberEmail());

			result = pstmt.executeUpdate();

		}finally {
			close(pstmt);	
		}
		return result;
	}

	/**@author 이지영
	 * 아이디 중복검사 
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public int idDupCheck(Connection conn, String memberId) throws Exception{
		int result = 0 ; //결과 저장 변수

		try {
			//			SQL얻어오기
			String sql = prop.getProperty("idDupCheck");

			//pstmt 생성
			pstmt = conn.prepareStatement(sql);

			//위치홀더에 알맞은 값 세팅 
			pstmt.setString(1, memberId);

			//select 수행후 결과 반환
			rs = pstmt.executeQuery();

			//rs.next()로 조회 결과 조회
			if(rs.next()) {
				result = rs.getInt(1); //1번 컬럼 결과를 result에 대입하겠다 
			}
		} finally {
			close(rs);
			close(pstmt);

		}
		return result;
	}

	/**@author 이미래
	 *  아이디 찾기 DAO
	 * @param conn
	 * @param memberName
	 * @param memberTel
	 * @throws Exception
	 * @return result
	 */
	public int searchId(Connection conn, String memberName, String memberTel) throws Exception {

		int result =0;

		try {
			// sql 얻어오기 

			String sql = prop.getProperty("searchId");

			// pstmt 생성 및 세팅 
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberName);
			pstmt.setString(2, memberTel);


			result=pstmt.executeUpdate();



		} finally {

			close(pstmt);

		}



		return result;
	}

	/**@author 이지영
	 * 회원정보 수전 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member mem)throws Exception {
		int result=0;

		try {
			String sql= prop.getProperty("updateMember");

			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, mem.getMemberName());
			pstmt.setString(2, mem.getMemberTel() );
			pstmt.setString(3, mem.getMemberAddress());
			pstmt.setInt(   4, mem.getMemberNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 비밀번호 변경 DAO
	 * @param conn
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(Connection conn, String currentPw, String newPw, int memberNo) throws Exception {
		int result =0;
		try {

			String sql = prop.getProperty("changePw");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newPw);
			pstmt.setInt(   2, memberNo);
			pstmt.setString(3, currentPw);

			result=pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		return result;	
	}
	
	/** 회원 탈퇴 DAO
	 * @author 임성수
	 * @param conn
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, int memberNo, String memberPw) throws Exception{
		
		int result = 0;
		try {
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,memberNo);
			pstmt.setString(2,memberPw);

			result = pstmt.executeUpdate();
			
		} finally {

			close(conn);
		}
		
		return result;
	}


}