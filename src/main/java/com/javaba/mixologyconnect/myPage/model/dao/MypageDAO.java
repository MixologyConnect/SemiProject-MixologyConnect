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

			String filePath = MypageDAO.class.getResource("/com/javaba/mixologyconnect/sql/mypage-sql.xml").getPath();

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
			
			while(rs.next()) {
				
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












	
	

	

	


	/** 북마크 표시 게시글 정보 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return bookMark
	 * @throws Exception
	 */
	public BookMark selectInfo(Connection conn, int boardNo)throws Exception {
		BookMark bk = new BookMark();
		try {
			
			String sql = prop.getProperty("selectInfo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			System.out.println("북마크 게시글번호 : "  + boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				bk.setBoardNo(rs.getInt(1));
				bk.setBoardTitle(rs.getString(2));
				bk.setMemberName(rs.getString(3));
				bk.setCreateDate(rs.getString(4));
				bk.setReadCount(rs.getInt(5));
				
			
				
				System.out.println(bk);
			}
			
			
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return bk;
	}

	
	



	/** 북마크 테이블 게시글 수 조회 DAO
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int bookMarkListCount(Connection conn, Member loginMember)throws Exception {
		int listCount = 0;
		
		try {
			
			String sql = prop.getProperty("listCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginMember.getMemberNo());
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				listCount = rs.getInt(1);
				
			}
			System.out.println("북마크게시글 수 : " + listCount);
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}


	
	/** 북마크 게시글 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @return
	 */
	public List<BookMark> bookMarkList(Connection conn, Pagination pagination, Member loginMember)throws Exception {
		List<BookMark> bookMarkList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectBookmark");
			
			// BETWEEN 구문에 들어갈 범위 계산
			int start = (pagination.getCurrentPage() - 1 ) * pagination.getLimit() + 1;

			int end = start + pagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginMember.getMemberNo());
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next()) {
				
				BookMark bk = new BookMark();
				
				bk.setBoardNo(rs.getInt("BOARD_NO"));
				bk.setBoardTitle(rs.getString("BOARD_TITLE"));
				bk.setMemberName(rs.getString("MEMBER_NICK"));
				bk.setCreateDate(rs.getString("CREATE_DT"));
				bk.setReadCount(rs.getInt("READ_COUNT"));
				
				bookMarkList.add(bk);
				
				
			}
			
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return bookMarkList;
	}


	/** 북마크 삽입 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int bookMarkInsert(Connection conn, BookMark bk, Member loginMember)throws Exception {
		int result = 0;
		try {
			
			String sql = prop.getProperty("insert");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginMember.getMemberNo());
			pstmt.setInt(2, bk.getBoardNo());
			pstmt.setString(3, bk.getBoardTitle());
			pstmt.setString(4, bk.getMemberName());
			pstmt.setInt(5, bk.getReadCount());
			
			result = pstmt.executeUpdate();
			System.out.println("insert 결과값 : " + result);
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 북마크 버튼 이미지 DAO
	 * @param conn
	 * @param boardNo
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int existNo(Connection conn, int boardNo, Member loginMember) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("btnImage");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, loginMember.getMemberNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				result = rs.getInt(1);
				System.out.println("북마크에 있? : " + result);
				
			}
			
			
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}


	/** 북마크 해제 DAO
	 * @param conn
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int delete(Connection conn, int boardNo, Member loginMember)throws Exception {
		int result = 0;
		try {
			
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 마이페이지 게시글 삭제 DAO
	 * @param conn
	 * @param arr
	 * @param condition
	 * @return result
	 * @throws Exception
	 */
	public int deletePost(Connection conn, String[] arr, String condition) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteMypage") + condition;
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			
			
			
			
			
		}finally {
			close(stmt);
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
