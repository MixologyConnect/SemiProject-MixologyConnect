package com.javaba.mixologyconnect.member.model.dao;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.nio.file.ClosedDirectoryStreamException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.member.model.vo.Member;


public class MemberDAO {

	private Statement stmt; 
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public MemberDAO() {
		try {
			prop = new Properties();
			String filePath =  MemberDAO.class.getResource("/com/javaba/mixologyconnect/sql/member-sql.xml").getPath(); 
			prop.loadFromXML(new FileInputStream(filePath));
		} catch(Exception e) {
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

			System.out.println(mem.getMemberName());
			System.out.println(mem.getMemberTel());
			System.out.println(mem.getMemberAddress());
			System.out.println(mem.getMemberNo());

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

			close(pstmt);
		}

		return result;
	}

	/**@author 이지영
	 * 프로필이미지 변경 Dao
	 * @param conn
	 * @param memberNo
	 * @param profileImage
	 * @return result
	 * @throws Exception
	 */
	public int updateProfileImage(Connection conn, int memberNo, String profileImage)throws Exception {

		int result=0;
		try {
			String sql = prop.getProperty("updateProfileImage");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(   1, profileImage);
			pstmt.setInt(2, memberNo);

			result = pstmt.executeUpdate();

		}finally {
			close(pstmt);
		}

		return result;
	}

	/** 아이디 찾기
	 * @author 이미래
	 * @param conn
	 * @param memberName
	 * @param memberTel
	 * @return member
	 * @throws Exception
	 */
	public Member selectOne(Connection conn, String memberName, String memberTel) throws Exception {

		Member member = null;

		try {
			String sql = prop.getProperty("searchId");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberName);
			pstmt.setString(2, memberTel);

			rs = pstmt.executeQuery();

			if(rs.next()) { // 조회 결과가 있는 경우
				member = new Member();
				member.setMemberId(rs.getString("MEMBER_ID"));
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return member;
	}

	public Member login(Connection conn, String inputId, String inputPw) throws Exception {
		Member loginMember = null;

		System.out.println(inputPw);

		try {
			String sql = prop.getProperty("login");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
				loginMember.setMemberId(rs.getString("MEMBER_ID"));
				loginMember.setMemberPw(rs.getString("MEMBER_NM"));
				loginMember.setMemberTel(rs.getString("MEMBER_TEL"));
				loginMember.setMemberName(rs.getString("MEMBER_NM"));
				loginMember.setMemberAddress(rs.getString("MEMBER_ADDR"));
				loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				loginMember.setProfileImage(rs.getString("MEMBER_PROFILE"));
				loginMember.setManagerCode(rs.getString("MANAGER_CODE"));
			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginMember;
	}


	/**@author 이미래
	 * 비밀번호 찾기 DAO
	 * @param conn
	 * @param memberId
	 * @param memberName
	 * @return member
	 * @throws Exception
	 */
	public Member searchPw(Connection conn, String memberId, String memberName) throws Exception{




		return null;
	}


	/**@author seongsuim
	 * @param conn
	 * @param memberId
	 * @return member
	 */
	public List<Member> selectMember(Connection conn, String column, String value) throws Exception {
		List<Member> members = new ArrayList<Member>();

		try { String sql = prop.getProperty("selectMember"); 
		pstmt = conn.prepareStatement(sql + " " + column + " " + "= ?");
		pstmt.setString(1, value);
		rs = pstmt.executeQuery();
		while (rs.next()) members.add(new Member(rs.getInt("MEMBER_NO"),
				rs.getString("MEMBER_ID"),
				rs.getString("MEMBER_PW"),
				rs.getString("MEMBER_TEL"),
				rs.getString("MEMBER_NM"),
				rs.getString("MEMBER_ADDR"),
				rs.getString("MEMBER_EMAIL"),
				rs.getString("MEMBER_PROFILE"),
				rs.getString("MANAGER_CODE"),
				rs.getString("SECESSION_FL")
				));
		} finally {
			close(rs); 
			close(pstmt); 
		}
		return members; 
	}

	public List<Member> selectFollowers(Connection conn, int memberNo) throws Exception {
		List<Member> followers = new ArrayList<Member>();


		try {
			String sql = prop.getProperty("selectFollowers");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			while (rs.next()) followers.add(new Member(rs.getInt("FOLLOWER_NO"),
					rs.getString("MEMBER_ID"),
					rs.getString("MEMBER_PW"),
					rs.getString("MEMBER_TEL"),
					rs.getString("MEMBER_NM"),
					rs.getString("MEMBER_ADDR"),
					rs.getString("MEMBER_EMAIL"),
					rs.getString("MEMBER_PROFILE"),
					rs.getString("MANAGER_CODE"),
					rs.getString("SECESSION_FL")
					));
		} finally {
			close(rs);
			close(pstmt);
		}

		return followers;
	}

	public List<Member> selectFollowings(Connection conn, int memberNo) throws Exception {
		List<Member> followings = new ArrayList<Member>();

		try {
			String sql = prop.getProperty("selectFollowings");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			while (rs.next()) followings.add(new Member(rs.getInt("MEMBER_NO"),
					rs.getString("MEMBER_ID"),
					rs.getString("MEMBER_PW"),
					rs.getString("MEMBER_TEL"),
					rs.getString("MEMBER_NM"),
					rs.getString("MEMBER_ADDR"),
					rs.getString("MEMBER_EMAIL"),
					rs.getString("MEMBER_PROFILE"),
					rs.getString("MANAGER_CODE"),
					rs.getString("SECESSION_FL")
					));
		} finally {
			close(rs);
			close(pstmt);
		}

		return followings;
	}



	/**@author ISS
	 * 관리자 회원 정보 변경 DAO
	 * @param conn
	 * @param memberId
	 * @return member
	 */
	public int managerSecession(Connection conn, String memberId) throws Exception{

		int result = 0;
		try {

			String sql = prop.getProperty("managerSecession"); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); 

			result = pstmt.executeUpdate();

		} finally { 
			close(pstmt);
		}

		return result;
	}

	/** 팔로잉 하기 위한 게시글 작성자 회원번호 조회 
	 * 
	 * @param conn
	 * @param boardNo
	 * @return
	 */
	public int selectBoardWrite(Connection conn, int boardNo) throws Exception{

		int boardWrite=0;
		try {
			String sql =prop.getProperty("selectBoardWrite");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			rs= pstmt.executeQuery();

			if(rs.next()) {
				boardWrite=rs.getInt("MEMBER_NO");
			}
		} finally {
			close(rs);
			close(pstmt);
		}


		return boardWrite;
	}


	/** 팔로우하기 
	 * @author 이지영
	 * @param conn
	 * @param boardWriter
	 * @param loginMemberNo
	 * @return
	 * @throws Exception
	 */
	public int insertfollow(Connection conn, int boardWriter, int loginMemberNo)throws Exception {

		int followResult=0;

		try {
			String sql = prop.getProperty("insertfollow");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, loginMemberNo);
			pstmt.setInt(2, boardWriter);

			followResult = pstmt.executeUpdate();

		}finally {
			close(pstmt);
		}
		return followResult;
	}


	/** 팔로우 취소 dao
	 * 
	 * @param conn
	 * @param boardWriter
	 * @param loginMemberNo
	 * @return
	 */
	public int deletefollow(Connection conn, int boardWriter, int loginMemberNo) throws Exception{

		int dfollowResult=0;

		try {
			String sql = prop.getProperty("deletefollow");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, loginMemberNo);
			pstmt.setInt(2, boardWriter);

			dfollowResult = pstmt.executeUpdate();

		}finally {
			close(pstmt);
		}
		return dfollowResult;
	}


	/**
	 * 로그인한 회원이 이미 팔로우한 회원인지 조회하는 Dao
	 * @param conn
	 * @param loginMemberNo
	 * @return
	 */
	public int selectFollower(Connection conn, int loginMemberNo, int memberNo) throws Exception{
		int followingNo=0;
		try {
			String sql = prop.getProperty("selectFollower");

			pstmt= conn.prepareStatement(sql);

			pstmt.setInt(1, loginMemberNo );
			pstmt.setInt(2, memberNo );

			rs=pstmt.executeQuery();

			if(rs.next()) {
				followingNo= rs.getInt("MEMBER_NO");
			}

		}finally {
			close(rs);
			close(pstmt);
		}
		return followingNo;
	}
	/**
	 * 팔로우 취소 dao
	 * @param conn
	 * @param loginMemberNo
	 * @param unfollowerNo
	 * @return result
	 */
	public int unfollow(Connection conn, int loginMemberNo, int unfollowerNo)throws Exception {
		int result =0; 

		try {
			String sql = prop.getProperty("deletefollow");

			pstmt =conn.prepareStatement(sql);

			pstmt.setInt(1, loginMemberNo);
			pstmt.setInt(2, unfollowerNo);

			result = pstmt.executeUpdate();

		}finally {
			close(pstmt);
		}
		return result;
	}

	public int cancleFollower(Connection conn, int loginMemberNo, int cancleFollower)throws Exception {
		int result =0; 

		try {
			String sql = prop.getProperty("deletefollow");

			pstmt =conn.prepareStatement(sql);

			pstmt.setInt(1, cancleFollower);
			pstmt.setInt(2, loginMemberNo);

			result = pstmt.executeUpdate();

		}finally {
			close(pstmt);
		}
		return result;
	}

	public int memberUpgrade(Connection conn, String memberId) throws Exception {
		
		int result = 0;
		try {

			String sql = prop.getProperty("memberUpgrade"); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); 

			result = pstmt.executeUpdate();

		} finally { 
			close(pstmt);
		}

		return result;
	}

	/** 상대방 팔로우 하기
	 * @param conn
	 * @param memberNo
	 * @return
	 */
	public int userPageFollower(Connection conn, int memberNo, int loginMemberNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertfollow");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(1, loginMemberNo);
		
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

}