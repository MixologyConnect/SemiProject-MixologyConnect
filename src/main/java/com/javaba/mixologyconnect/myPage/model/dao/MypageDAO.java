package com.javaba.mixologyconnect.myPage.model.dao;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.board.model.dao.BoardDAO;
import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.Pagination;
import com.javaba.mixologyconnect.member.model.vo.Member;
import com.javaba.mixologyconnect.myPage.model.vo.BookMark;


public class MypageDAO {
	
	
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;
	
	
	public MypageDAO() {
		try {
			prop = new Properties();

			String filePath = BoardDAO.class.getResource("/com/javaba/mixologyconnect/sql/mypage-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/** 마이페이지 나의 게시글 수 조회 DAO
	 * @param conn
	 * @param loginMember
	 * @return listCount
	 * @throws Exception
	 */
	public int MyPageListCount(Connection conn, Member loginMember) throws Exception {
		int listCount = 0;

		try {

			String sql = prop.getProperty("MyPageListCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, loginMember.getMemberNo());

			rs = pstmt.executeQuery();

			if(rs.next()) {
				listCount = rs.getInt(1);
			}







		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("마이페이지 게시글 수 : " + listCount);
		return listCount;
	}

	
	/** 마이페이지 나의 게시글 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param loginMember
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> MyPageBoardCount(Connection conn, Pagination pagination, Member loginMember) throws Exception{

		List<Board> boardList = new ArrayList<>();

		try {

			String sql = prop.getProperty("MyPageBoardCount");

			// BETWEEN 구문에 들어갈 범위 계산
			int start = (pagination.getCurrentPage() - 1 ) * pagination.getLimit() + 1;

			int end = start + pagination.getLimit() - 1;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, loginMember.getMemberNo());
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				System.out.println("이름 : " + rs.getString("MEMBER_NM"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));

				boardList.add(board);


			}



		}finally {
			close(rs);
			close(pstmt);
		}


		return boardList;
	}


	/** 북마크 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return boardList
	 * @throws Exception
	 */
	public List<BookMark> bookMarkList(Connection conn, int boardNo) throws Exception {
		
		List<BookMark> bookMarkList = new ArrayList<>();
		try {
			
			String sql = prop.getProperty("bookMark");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				BookMark bookMark = new BookMark();
				
				bookMark.setBoardNo(rs.getInt(1));
				bookMark.setBoardTitle(rs.getString(2));
				bookMark.setMemberName(rs.getString(3));
				bookMark.setReadCount(rs.getInt(4));
				
				bookMarkList.add(bookMark);
				
			}
			
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return bookMarkList;
	}






	/** 북마크 게시글 회원번호 얻어오기 DAO
	 * @param conn
	 * @param boardNo
	 * @return memberNo
	 * @throws Exception
	 */
	public int bookMarkMemberNo(Connection conn, int boardNo) throws Exception{
		
		int memberNo = 0;
		
		try {
			
			String sql = prop.getProperty("memberNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberNo = rs.getInt(1);
				System.out.println("회원번호 : " + memberNo);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return 0;
	}


	/** 북마크 삽입 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int bookMarkInsert(Connection conn, int memberNo, int boardNo)throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insert");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
			
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
