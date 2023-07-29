package com.javaba.mixologyconnect.board.model.dao;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.board.model.vo.Board;
import com.javaba.mixologyconnect.board.model.vo.BoardDetail;
import com.javaba.mixologyconnect.board.model.vo.BoardImage;
import com.javaba.mixologyconnect.board.model.vo.Pagination;
import com.javaba.mixologyconnect.member.model.vo.Member;

public class BoardDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public BoardDAO() {

		try {
			prop = new Properties();

			String filePath = BoardDAO.class.getResource("/com/javaba/mixologyconnect/sql/board-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시글 제목 조회
	 * 
	 * @param conn
	 * @param type
	 * @return boardTitle
	 * @throws Exception
	 */
	public String boardTitle(Connection conn, int type) throws Exception {

		String boardTitle = null;

		try {

			String sql = prop.getProperty("selectBoardAll");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardTitle = rs.getString(1);
			}

		} finally {
			close(rs);
			close(pstmt);

		}
		return boardTitle;
	}

	/**
	 * 게시글 수 조회
	 * 
	 * @param conn
	 * @param type
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int type) throws Exception {
		int listCount = 0;

		try {

			String sql = prop.getProperty("getListCount");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(pstmt);

		}

		return listCount;
	}

	/**
	 * 게시글 목록 조회
	 * 
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return boardList
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination, int type) throws Exception {

		List<Board> boardList = new ArrayList<Board>();

		try {

			String sql = prop.getProperty("selectBoardList");

			pstmt = conn.prepareStatement(sql);

			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() - 1;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));

				boardList.add(board);

			}

		} finally {
			close(rs);
			close(pstmt);

		}

		return boardList;
	}

	/**
	 * 게시글 상세 조회
	 * 
	 * @param conn
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(Connection conn, int boardNo) throws Exception {

		BoardDetail detail = null;

		try {

			String sql = prop.getProperty("selectBoardDetail");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				detail = new BoardDetail();

				detail.setBoardNo(rs.getInt("BOARD_NO"));
				detail.setBoardTitle(rs.getString("BOARD_TITLE"));
				detail.setBoardContent(rs.getString("BOARD_CONTENT"));
				detail.setBoardDate(rs.getString("BOARD_DT"));
				detail.setModifyDate(rs.getString("MODIFY_DT"));
				detail.setReadCount(rs.getInt("READ_COUNT"));
				detail.setMemberName(rs.getString("MEMBER_NM"));
				detail.setMemberNo(rs.getInt("MEMBER_NO"));
				detail.setBoardName(rs.getString("BOARD_NM"));
				detail.setProfileImage(rs.getString("MEMBER_PROFILE"));
				
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return detail;
	}

	/** 게시글 이미지 리스트 조회
	 * @param conn
	 * @param boardNo
	 * @return imageList
	 */
	public List<BoardImage> selectImageList(Connection conn, int boardNo) throws Exception {
		System.out.println("게시글 이미지 리스트 조회 다오 왔다");
		List<BoardImage> imageList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectImageList");
			
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardImage image = new BoardImage();
	            
	            image.setImageNo(rs.getInt("IMG_NO"));
	            image.setImageRename(rs.getString("IMG-RENAME"));
	            image.setImageOriginal(rs.getString("IMG_ORIGINAL"));
	            image.setImageLevel(rs.getInt("IMG_LEVEL"));
	            image.setBoardNo(rs.getInt("BOARD_NO"));
	            
	            imageList.add(image);
	            
			}
			System.out.println("imageList : " +  imageList);
			
					
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return imageList;
	}

	/** 마이페이지 나의 게시글 수 조회 DAO
	 * @param conn
	 * @param loginMember
	 * @return listCount
	 * @throws Exception
	 */
	public int MyPageListCount(Connection conn, Member loginMember) throws Exception{
		
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

	

	


}
