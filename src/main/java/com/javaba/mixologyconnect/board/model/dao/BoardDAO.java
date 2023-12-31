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


			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setInt(3, type);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setThumbnail(rs.getString("IMG_RENAME"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));

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


	/**@author 임성수
	 * 게시글 조회 DAO
	 * @param conn
	 * @param board
	 * @param boardTitle
	 * @return board
	 */
	public Board searchBoard(Connection conn, Member member, String boardTitle) throws Exception {

		Board board = new Board();

		try {

			String sql = prop.getProperty("searchBoard");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setMemberTel(rs.getString("MEMBER_TEL"));
				board.setBoardSt(rs.getString("BOARD_ST"));
			}

		} finally {
			close(rs);
			close(pstmt);

		}

		return board;
	}


	/** 게시글 번호 찾기
=======
	public List<BoardImage> selectThumbnail(Connection conn, int type) throws Exception{

		List<BoardImage> imageList = new ArrayList<BoardImage>();

		try {
			String sql = prop.getProperty("selectThumbnail");
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, type);

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


		}finally {
			close(rs);
			close(pstmt);
		}



		return imageList;
	}


	/**조하요 했을 시 DAO
	 * @author 이지영

	 * @param conn
	 * @param memberNo
	 * @param boardNo
	 * @return likeResult
	 */
	public int insertLike(Connection conn, int memberNo, int boardNo) throws Exception {

		int likeResult = 0;

		try {
			String sql = prop.getProperty("insertLike");

			pstmt = conn.prepareStatement(sql);

			//
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, boardNo);

			likeResult = pstmt.executeUpdate(); 

		}finally {
			close(pstmt);
		}

		return likeResult;
	}


	/**좋아요 취소 했을 시 DAO
	 * @author 이지영
	 * @param conn
	 * @param memberNo
	 * @param boardNo
	 * @return dlikeResult
	 */
	public int deleteLike(Connection conn, int memberNo, int boardNo)throws Exception {
		int dlikeResult = 0;

		try {
			String sql = prop.getProperty("deleteLike");

			pstmt = conn.prepareStatement(sql);

			//
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, boardNo);

			dlikeResult = pstmt.executeUpdate(); 

		}finally {
			close(pstmt);
		}

		return dlikeResult;
	}


	/** 특성 게시글에 조하요 수 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @param boardNo
	 * @return likeCount
	 */
	public int selectLike(Connection conn, int boardNo) throws Exception{

		int likeCount = 0;

		try {

			String sql = prop.getProperty("selectLike");

			pstmt= conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			rs=pstmt.executeQuery();

			if(rs.next()) {
				likeCount=rs.getInt("COUNT(*)");
			}



		} finally {
			close(rs);
			close(pstmt);
		}


		return likeCount;

	}

	/**@author 이지영
	 * 회원이 좋아요 놀렀었는 지 확인하는 게시글 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @param memberNo
	 * @return
	 */
	public int selectMemberLike(Connection conn, int boardNo, int memberNo) throws Exception {

		int likeMember=0;
		try {
			String sql = prop.getProperty("selectMemberLike");

			pstmt= conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, boardNo);

			rs=pstmt.executeQuery();

			if(rs.next()) {
				likeMember=rs.getInt("BOARD_NO");
			}

		}finally {
			close(rs);
			close(pstmt);
		}
		return likeMember;
	}

	/** 관리자 게시글 삭제 DAO
	 * @param conn
	 * @param boardTitle
	 * @return result
	 */
	public int managerBoardDelete(Connection conn, String boardTitle) throws Exception {
		
		int result = 0;
		
		try {

			String sql = prop.getProperty("managerBoardDelete"); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle); 

			result = pstmt.executeUpdate();
			
		} finally { 
			close(pstmt);
		}
		
		return result;
	}

	/** 인기순 게시글 목록
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardPopularity(Connection conn, Pagination pagination, int type) throws Exception {
		
		List<Board> boardList = new ArrayList<Board>();

		try {

			String sql = prop.getProperty("selectBoardPopularity");

			pstmt = conn.prepareStatement(sql);

			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() - 1;


			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setInt(3, type);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setThumbnail(rs.getString("IMG_RENAME"));


				boardList.add(board);

			}

		} finally {
			close(rs);
			close(pstmt);

		}

		return boardList;
		
	}

	/**팔로우한 사람의 게시글 수 조회
	 * @throws Exception
	 * @param conn
	 * @param type
	 * @return listCount
	 */
	public int getFollowListCount(Connection conn, int type, int loginMemberNo) throws Exception {
		int listCount = 0;

		try {

			String sql = prop.getProperty("getFollowListCount");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			pstmt.setInt(2, loginMemberNo);
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

	/**팔로우한 게시글 목록 리스트
	 * 
	 * @param conn
	 * @param pagination
	 * @param type
	 * @param loginMemberNo
	 * @return
	 */
	public List<Board> selectFollowBoardList(Connection conn, Pagination pagination, int type, int loginMemberNo) throws Exception{

		List<Board> boardList = new ArrayList<Board>();

		try {

			String sql = prop.getProperty("selectFollowBoardList");

			pstmt = conn.prepareStatement(sql);

			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() - 1;


			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setInt(3, type);
			pstmt.setInt(4, loginMemberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setThumbnail(rs.getString("IMG_RENAME"));


				boardList.add(board);

			}

		} finally {
			close(rs);
			close(pstmt);

		}

		return boardList;
	}

	/** 공지사항 작성
	 * @param conn
	 * @param detail
	 * @param boardType
	 * @return result
	 */
	public int insertNotice(Connection conn, BoardDetail detail, int boardType) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertNotice");
			
			pstmt = conn.prepareStatement(sql);
			// pstmt.setInt(1, detail.getBoardNo());
			pstmt.setString(1, detail.getBoardTitle());
			pstmt.setString(2, detail.getBoardContent());
			pstmt.setInt(3, boardType);
			pstmt.setInt(4, detail.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}

	public BoardDetail selectNoticeDetail(Connection conn) throws Exception {
		
		BoardDetail detail = new BoardDetail();
		
		try {
			String sql = prop.getProperty("selectNotice");
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				
				detail.setBoardTitle(rs.getString("BOARD_TITLE"));
				detail.setBoardContent(rs.getString("BOARD_CONTENT"));
				 
			}

		} finally {
			close(rs);
			close(stmt);
		}
		
		return detail;
	}

	public List<BoardImage> selectImageList(Connection conn) throws Exception {
		
		List<BoardImage> imageList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("noticeImage");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				BoardImage image = new BoardImage();
				
				image.setImageRename(rs.getString("IMG_RENAME"));
				image.setImageOriginal(rs.getString("IMG_ORIGINAL"));
				image.setBoardNo(rs.getInt("BOARD_NO"));
				
				imageList.add(image);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return imageList;
	}

	public int noticeUpdate(Connection conn, BoardDetail detail) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("noticeUpdate");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, detail.getBoardContent());
			pstmt.setString(2, detail.getBoardTitle());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int noticeUpdate(Connection conn, BoardImage img) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("noticeImageUpdate");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img.getImageRename());
			pstmt.setString(2, img.getImageOriginal());
			pstmt.setInt(3, img.getImageLevel());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;

	}

	public BoardDetail selectBoardCode(Connection conn) throws Exception {

		BoardDetail detail = new BoardDetail();

		try {
			String sql = prop.getProperty("selectBoardCode");
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {

				detail.setBoardCode(rs.getInt("BOARD_CD"));

			}

		} finally {
			close(rs);
			close(stmt);
		}

		return detail;
	}

	public int insertNoticeImage(Connection conn, BoardImage image) throws Exception {
		int result = 0;

		try {

			String sql = prop.getProperty("noticeInsert");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, image.getImageRename());
			pstmt.setString(2, image.getImageOriginal());
			pstmt.setInt(3, image.getImageLevel());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	


	public List<Board> selectTop4(Connection conn) throws Exception {

		List<Board> Top4Board = new ArrayList<Board>();

		try {
			String sql = prop.getProperty("selectTop4");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setBoardTitle(rs.getNString("BOARD_TITLE"));
				board.setThumbnail(rs.getNString("IMG_RENAME"));
				Top4Board.add(board);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return Top4Board;
	}
}
