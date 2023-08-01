package com.javaba.mixologyconnect.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.service.ReplyService;
import com.javaba.mixologyconnect.board.model.vo.BoardDetail;
import com.javaba.mixologyconnect.board.model.vo.BoardImage;
import com.javaba.mixologyconnect.board.model.vo.Reply;
import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;



@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int boardNo = Integer.parseInt(req.getParameter("no"));


			BoardService service = new BoardService();
			MemberService service2 = new MemberService();
			BoardDetail detail = service.selectBoardDetail(boardNo);

			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember"));
			int loginMemberNo = loginMember.getMemberNo();
			
			//좋아요 관련
			int likeMember=0;
			//팔로우 관련
			int writerNo= 0;
			if(loginMember!=null) {
				int memberNo = loginMember.getMemberNo();
				likeMember = service.selectMemberLike(boardNo, memberNo);
				writerNo = service2.selectFollower(loginMemberNo);
			}

			int likeCount = service.selectLike(boardNo);

			
			

			List<BoardImage> ImageList = detail.getImageList();

			if(detail != null) {
				List<Reply> rList = new ReplyService().selectReplyList(boardNo);
				req.setAttribute("rList", rList);
			}

			if(detail.getImageList() != null) {

				for( BoardImage imageList : ImageList) {

					System.out.println("imageList : " +  imageList);


				}
			}

			req.setAttribute("detail", detail);
			req.setAttribute("likeCount", likeCount);

			req.setAttribute("likeMember", likeMember);
			req.setAttribute("writerNo", writerNo);


			String path = "/WEB-INF/views/board/boardDetail.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);

			dispatcher.forward(req, resp);

		}catch (Exception e) {
			e.printStackTrace();

		}



	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		try {

			int boardNo = Integer.parseInt(req.getParameter("boardNo"));

			BoardService service = new BoardService();

			List<BoardImage> imageList = service.selectImage(boardNo);

			System.out.println("imageList : " +  imageList);

			resp.getWriter().print(imageList);			


		}catch (Exception e) {
			e.printStackTrace();

		}


	}
}
