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

	/**
	 * 게시글 이미지 리스트 조회
	 * 
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

			while (rs.next()) {
				BoardImage image = new BoardImage();

				image.setImageNo(rs.getInt("IMG_NO"));
				image.setImageRename(rs.getString("IMG_RENAME"));
				image.setImageOriginal(rs.getString("IMG_ORIGINAL"));
				image.setImageLevel(rs.getInt("IMG_LEVEL"));
				image.setBoardNo(rs.getInt("BOARD_NO"));

				imageList.add(image);

			}
			System.out.println("imageList : " + imageList);

		} finally {
			close(rs);
			close(pstmt);
		}

		return imageList;
	}

	/**
	 * 다음 게시글 번호 구하기
	 * 
	 * @param conn
	 * @return boardNo
	 */
	public int boardNo(Connection conn) throws Exception {

		int boardNo = 0;

		try {
			String sql = prop.getProperty("boardNo");
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				boardNo = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(stmt);
		}

		return boardNo;
	}

	/**
	 * 게시글 작성
	 * 
	 * @param conn
	 * @param detail
	 * @param boardType
	 * @return
	 */
	public int boardInsert(Connection conn, BoardDetail detail, int boardType) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("boardInsert");
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, detail.getBoardNo());
			pstmt.setString(2, detail.getBoardTitle());
			pstmt.setString(3, detail.getBoardContent());
			pstmt.setInt(4, boardType);
			pstmt.setInt(5, detail.getMemberNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 이미지 삽입
	 * 
	 * @param conn
	 * @param image
	 * @return result
	 * @throws Exception
	 */
	public int insertBoardImage(Connection conn, BoardImage image) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("imageInsert");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, image.getImageRename());
			pstmt.setString(2, image.getImageOriginal());
			pstmt.setInt(3, image.getImageLevel());
			pstmt.setInt(4, image.getBoardNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 게시글 수정
	 * 
	 * @param conn
	 * @param detail
	 * @return result
	 * @throws Exception
	 */
	public int boardUpdate(Connection conn, BoardDetail detail) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("boardUpdate");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, detail.getBoardContent());
			pstmt.setString(2, detail.getBoardTitle());
			pstmt.setInt(3, detail.getBoardNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 이미지 수정
	 * 
	 * @param conn
	 * @param img
	 * @return result
	 * @throws Exception
	 */
	public int boardUpdate(Connection conn, BoardImage img) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("imageUpdate");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img.getImageRename());
			pstmt.setString(2, img.getImageOriginal());
			pstmt.setInt(3, img.getBoardNo());
			pstmt.setInt(4, img.getImageLevel());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;

	}

	/**
	 * 이미지 삭제
	 * 
	 * @param conn
	 * @param deleteList
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoardImage(Connection conn, String deleteList, int boardNo) throws Exception {
		int result = 0;

		try {
			// 완성되지 않은 SQL
			String sql = prop.getProperty("deleteBoardImage") + deleteList + ")";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 게시글 삭제
	 * 
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int boardDelete(Connection conn, int boardNo) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("boardDelete");
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 조회수 증가
	 * 
	 * @param conn
	 * @param boardNo
	 * @return result
	 */
	public int ReadCountUp(Connection conn, int boardNo) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("ReadCountUp");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);

		}

		return result;
	}

}
