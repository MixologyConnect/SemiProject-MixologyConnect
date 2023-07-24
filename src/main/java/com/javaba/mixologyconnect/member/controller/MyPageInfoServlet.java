package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/member/myPage/info")
public class MyPageInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path="/WEB-INF/views/member/myPage-info.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberName = req.getParameter("memberName");
		String memberTel = req.getParameter("memberTel");
		
		String[] address = req.getParameterValues("memberAddress");
		
		String memberAddress= null;
		
		if(!address[0].equals("")) {
			memberAddress = String.join(",,", address);
		}
		
		HttpSession session = req.getSession();
		
		Member loginMember =(Member)(session.getAttribute("loginMember"));
		
		int memberNO = loginMember.getMemberNo();
		
		Member mem = new Member();
		mem.setMemberName(memberName);
		mem.setMemberTel(memberTel);
		mem.setMemberAddress(memberAddress);
		
		try {
			MemberService service = new MemberService();
			
			int result = service.updateMember(mem);
			
			if(result > 0) {
				session.setAttribute("message", "회원정보가 수정되었습니다.");
				
				loginMember.setMemberName(memberName);
				loginMember.setMemberTel(memberTel);
				loginMember.setMemberAddress(memberAddress);
			
			}else {
				session.setAttribute("message", "회원정보 수정이 실패되었습니다.");
			}
			
			resp.sendRedirect( req.getContextPath() + "/member/myPage/info");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
