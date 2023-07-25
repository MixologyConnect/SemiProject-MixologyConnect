package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.common.MyRenamePolicy;
import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;




@WebServlet("/member/myPage/profile")
public class MyPageProfileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path="/WEB-INF/views/member/myPage-profile.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int maxSize = 1024* 1024 * 20;
			HttpSession session= req.getSession();
			String root = session.getServletContext().getRealPath("/");
			String folderPath = "/resources/images/memberProfile/";
			String filePath = root + folderPath;
			String encoding = "UTF-8";
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());

			Member loginMember = (Member)(session.getAttribute("loginMember"));
			int memberNo = loginMember.getMemberNo();

			System.out.println( mpReq.getOriginalFileName("profileImage"));

			System.out.println(mpReq.getFilesystemName("profileImage"));

			String profileImage = folderPath + mpReq.getFilesystemName("profileImage");

			int delete = Integer.parseInt(mpReq.getParameter("delete"));
			
			if(delete == 1) {
				profileImage = null;
			}
			
			
			MemberService service = new MemberService();

			int result = service.updateProfileImage(memberNo, profileImage);

			if(result > 0) {
				session.setAttribute("message", "프로필 사진이 변경되었습니다.");
			}else {
				session.setAttribute("massage","프로필 사진이 변경에 실패했습니다.");
			}

			 resp.sendRedirect("profile");


		}catch (Exception e) {
			e.printStackTrace();
		}


	}

}
