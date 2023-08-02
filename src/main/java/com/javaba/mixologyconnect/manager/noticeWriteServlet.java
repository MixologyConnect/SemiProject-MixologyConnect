package com.javaba.mixologyconnect.manager;

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
import com.javaba.mixologyconnect.manager.service.ManagerService;
import com.javaba.mixologyconnect.manager.vo.NoticeDetail;
import com.javaba.mixologyconnect.manager.vo.NoticeImage;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/manager/noticeWrite")
public class noticeWriteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		try {
			int maxSize = 1024 * 1024 * 100;
			HttpSession session = req.getSession();
			String root = session.getServletContext().getRealPath("/");
			String folderPath = "/resources/images/notice/";
			String filePath = root + folderPath;

			String encoding = "UTF-8";

			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());

			Enumeration<String> files = mpReq.getFileNames();

			List<BoardImage> imageList = new ArrayList<BoardImage>();

			while(files.hasMoreElements()) {
				String name = files.nextElement();

				String rename = mpReq.getFilesystemName(name);
				String original = mpReq.getOriginalFileName(name);

				if (rename != null) {

					BoardImage image = new BoardImage();

					image.setImageOriginal(original);
					image.setImageRename(folderPath + rename);
					image.setImageLevel(Integer.parseInt(name));

					imageList.add(image);
				}
			}
			String noticeName = mpReq.getParameter("noticeTitle");
			String noticeContent = mpReq.getParameter("content");
			int boardCode = Integer.parseInt(mpReq.getParameter("type"));

			BoardDetail detail = new BoardDetail();
			
			detail.setBoardTitle(noticeName);
			detail.setBoardContent(noticeContent);
			
			String mode = mpReq.getParameter("mode");
			
			BoardService service = new BoardService();
			
			if(mode.equals("insert")) {
				
				int boardNo = service.insertNotice(detail,imageList, boardCode);
				
				String path = null;
				
				
			}
			


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
