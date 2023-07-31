package com.javaba.mixologyconnect.column.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.board.model.service.BoardService;
import com.javaba.mixologyconnect.board.model.vo.BoardDetail;
import com.javaba.mixologyconnect.board.model.vo.BoardImage;
import com.javaba.mixologyconnect.common.MyRenamePolicy;
import com.javaba.mixologyconnect.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/column/columnWrite")
public class ColumnWriteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String mode=req.getParameter("mode");
			if(mode.equals("update")) {
				
			}
			String path = "/WEB-INF/views/column/columnWrite.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int maxSize =1024 * 1024 * 100;
			
			HttpSession session =req.getSession();
			String root = session.getServletContext().getRealPath("/");
			String folderPath ="/resources/images/column/";
			String filePath =root+folderPath;
			
			String encoding = "UTF-8";
			
			MultipartRequest mpReq= new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			
			Enumeration<String> files = mpReq.getFileNames();
			
			List<BoardImage> imageList =new ArrayList<>();
			
			
			while (files.hasMoreElements()) {
				String name = files.nextElement();
				
				System.out.println("name : "+name);
				String rename = mpReq.getFilesystemName(name);
				String original = mpReq.getOriginalFileName(name);
				
				if(rename != null) {
					BoardImage columnImg= new BoardImage();
					columnImg.setImageOriginal(original);
					columnImg.setImageRename(folderPath+rename);
					columnImg.setImageLevel(Integer.parseInt(name));
					
					imageList.add(columnImg);
				}
			}
			
			
		String boardTitle = mpReq.getParameter("boardTitle");
		String boardContent = mpReq.getParameter("boardContent");
		int boardCode = Integer.parseInt(mpReq.getParameter("type"));
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo();
		
		BoardDetail detail = new BoardDetail();
		
		detail.setBoardTitle(boardTitle);
		detail.setBoardContent(boardContent);
		detail.setMemberNo(memberNo);
		
		
		BoardService service = new BoardService();
		String mode = mpReq.getParameter("mode");
		
		if(mode.equals("insert")) {
			int boardNo = service.boardInsert(detail, imageList, boardCode);
			
			
			String path = null;
			if(boardNo > 0) {
				session.setAttribute("message", "게시글이 등록되었습니다.");
				path = "columnDetail?no="+boardNo+"&type="+boardCode;
			}else {
				session.setAttribute("message", "게시글이 등록이 실패되었습니다.");
				path="columnWrite?"+mode+"&type="+boardCode;
			}
			resp.sendRedirect(path);
		}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
