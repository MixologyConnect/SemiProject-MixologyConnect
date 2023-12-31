package com.javaba.mixologyconnect.member.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.member.model.dao.MemberDAO;
import com.javaba.mixologyconnect.member.model.vo.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();

	/**
	 * @author 이지영 회원가입 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member mem) throws Exception {

		Connection conn = getConnection();

		int result = dao.signUp(conn, mem);

		// 트렌젝션 처리
		if (result > 0)
			conn.commit();
		else
			conn.rollback();

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
	 * 
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String memberId) throws Exception {
		Connection conn = getConnection(); // DBCP에서 만들어 둔 커넥션 얻어오기

		int result = dao.idDupCheck(conn, memberId);

		close(conn);

		return result;
	}

	/**
	 * @author 이미래 아이디 찾기 Service
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

	/**
	 * @author 이지영 회원정보 수정 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member mem) throws Exception {

		Connection conn = getConnection();

		int result = dao.updateMember(conn, mem);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(getConnection());

		return result;
	}

	/**
	 * @author 이지영 비밀번호 변경 Service
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 * 
	 */
	public int changePw(String currentPw, String newPw, int memberNo) throws Exception {
		Connection conn = getConnection(); // DBCP에서 얻어옴

		int result = dao.changePw(conn, currentPw, newPw, memberNo);

		if (result > 0)
			conn.commit();
		else
			conn.rollback();

		close(conn);

		return result;
	}

	/**
	 * 회원탈퇴 Service
	 * 
	 * @author 임성수
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String memberPw) throws Exception {

		Connection conn = getConnection();

		int result = dao.secession(conn, memberNo, memberPw);

		if (result > 0)
			conn.commit();
		else
			conn.rollback();

		close(conn);

		return result;
	}

	/**
	 * @author 이지영 프로필 사진 변경 service
	 * @param memberNo
	 * @param profileImage
	 * @return result
	 */
	public int updateProfileImage(int memberNo, String profileImage) throws Exception {
		Connection conn = getConnection(); // DBCP에서 얻어옴

		int result = dao.updateProfileImage(conn, memberNo, profileImage);

		if (result > 0)
			conn.commit();
		else
			conn.rollback();

		close(conn);

		return result;
	}

	/** @author 이미래
	 * 비밀번호 찾기 Service
	 * @param memberId
	 * @param memberName
	 * @return member
	 * @throws Exception
	 */
	public Member searchPw(String memberId, String memberName) throws Exception{

		Connection conn = getConnection();

		Member member = dao.searchPw(conn, memberId, memberName);

		close(conn);

		return member;
	}		

	/**
	 * @author seongsuim 회원 조회 service
	 * @param memberId
	 * @return member
	 */
	public Member selectMember(String memberId) throws Exception {
		Connection conn = getConnection();

		Member member = dao.selectMember(conn, "MEMBER_ID", memberId).get(0);

		close(conn);

		return member; 
	}

	public List<Member> selectFollowers(int memberNo) throws Exception {
		Connection conn = getConnection();

		List<Member> followers = dao.selectFollowers(conn, memberNo);

		close(conn);

		return followers;
	}

	public List<Member> selectFollowings(int memberNo) throws Exception {
		Connection conn = getConnection();

		List<Member> followings = dao.selectFollowings(conn, memberNo);

		close(conn);

		return followings;
	}


	
	/**@author 지영
	 * 팔로우 
	 * @param loginMemberNo
	 * @param boardNo
	 * @return
	 */
	public Map<String, Integer> followInsertDelete(int loginMemberNo, int boardNo, int followCheck) throws Exception {

		Connection conn = getConnection();

		//게시글 작성자 회원번호 조회 
		int boardWriter = dao.selectBoardWrite(conn, boardNo); //게시글 작성자 조회
		int followingNo= 0; //팔로우 당하는 게시글 작성자 번호 
		int dFollowResult=0; // 팔로우 취소 결과 
		int followResult = 0; // 팔로우 추가 결과 
		
		
		followingNo = dao.selectFollower(conn, loginMemberNo, boardWriter);
		if(followingNo==boardWriter) {
			if(followCheck == 0) {
				//팔로우 취소하기 결과 변환 변수
				dFollowResult = dao.deletefollow(conn, boardWriter, loginMemberNo);
			}
		}else {
			
			if(followCheck > 0) {
				// 팔로우하기 결과 반환 변수
				followResult = dao.insertfollow(conn, boardWriter, loginMemberNo);
			}else {
				//팔로우 취소 결과 
				dFollowResult = dao.deletefollow(conn, boardWriter, loginMemberNo);
			}
		}
		

		Map<String, Integer> map = new HashMap<>();

		map.put("boardWriter", boardWriter); //게시글 작성자 
		map.put("followResult", followResult); // 팔로우 추가 결과
		map.put("dFollowResult", dFollowResult);//팔로우 취소 결과 
		map.put("followingNo", followingNo); //팔로우 당하는 게시글 자성자의 번호 

		if(followCheck > 0) {
			if(followResult> 0) 	commit(conn);
			else 				rollback(conn);
			
		}
		if(followCheck == 0) {
			if(dFollowResult> 0) 	commit(conn);
			else 				rollback(conn);
		}

		close(conn);
		return map;

		
	}

	/**@author ISS
	 * @param memberId
	 * @return
	 */
	public int managerSecession(String memberId) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.managerSecession(conn, memberId);

		if (result > 0)
			conn.commit();
		else
			conn.rollback();

		close(conn);

		return result;

	}

	/**로그인한 회원이 현재 글 작성자를 팔로우 했는지 조회
	 * @param loginMemberNo
	 * @return
	 */
	public int selectFollower(int loginMemberNo, int writerNo ) throws Exception {
		int followingNo = 0;
		Connection conn = getConnection();
		followingNo = dao.selectFollower(conn, loginMemberNo, writerNo);
		close(conn);
		return followingNo;
	}

	public Object findID(String name, String email) throws Exception {
		Member member = null;

		Connection conn = getConnection();

		List<Member> members = dao.selectMember(conn, "MEMBER_NM", name);
		List<Member> members2 = dao.selectMember(conn, "MEMBER_EMAIL", email);

		if (members.size() > 0) member = members2.get(0);

		close(conn);

		if (members.toString().contains(member.toString())) return members.get(0).getMemberId();
		else return false;
	}

	public Object findPW(String id, String email) throws Exception {
		Member member = null;

		Connection conn = getConnection();

		List<Member> members = dao.selectMember(conn, "MEMBER_ID", id);
		List<Member> members2 = dao.selectMember(conn, "MEMBER_EMAIL", email);

		if (members.size() > 0) member = members2.get(0);

		if (members.toString().contains(member.toString())) {
			String temp = "";
			for (int i = 0; i < 10; i++) {
				int random = 48 + (int)Math.floor(Math.random() * 61);
				if (random > 83) random += 13;
				else if (random > 57) random += 7;
				temp += (char)random;
			}
			String encryptPw = null;
			MessageDigest md = null; 
			try {
				
				md= MessageDigest.getInstance("SHA-512");
				byte[] bytes= temp.getBytes(Charset.forName("UTF-8"));
				md.update(bytes);
				encryptPw =Base64.getEncoder().encodeToString(md.digest());
			}catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			changePw(members.get(0).getMemberPw(), encryptPw, members.get(0).getMemberNo());
			return temp;
		}
		else return false;
	}

	/**
	 * 팔로우 취소 
	 * @param loginMemberNo
	 * @param unfollowerNo
	 * @return
	 */
	public int unfollow(int loginMemberNo, int unfollowerNo)throws Exception {
		Connection conn = getConnection();
		int result = dao.unfollow(conn, loginMemberNo, unfollowerNo);
		if (result > 0)
			conn.commit();
		else
			conn.rollback();

		close(conn);

		return result;
	}

	public int cancleFollower(int loginMemberNo, int cancleFollower)throws Exception {
		Connection conn = getConnection();
		int result = dao.cancleFollower(conn, loginMemberNo, cancleFollower);
		if (result > 0)
			conn.commit();
		else
			conn.rollback();

		close(conn);

		return result;
	}

	public int memberUpgrade(String memberId) throws Exception {
			
		Connection conn = getConnection();
		
		int result = dao.memberUpgrade(conn, memberId);
		
		System.out.println(result);

		if (result > 0)
			conn.commit();
		else
			conn.rollback();

		close(conn);

		return result;

	}

	/** 상대방 팔로우 하기
	 * @param memberNo
	 * @return
	 */
	public int userPageFollower(int memberNo, int loginMemberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.userPageFollower(conn, memberNo, loginMemberNo);
		
		if (result > 0)
			conn.commit();
		else
			conn.rollback();

		close(conn);
		
		return result;
	}

}