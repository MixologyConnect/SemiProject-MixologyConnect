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

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path ="/WEB-INF/views/member/signUp.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 파라미터 얻어오기 
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String memberTel = req.getParameter("memberTel");
		String memberName = req.getParameter("memberName");
		String memberEmail = req.getParameter("memberEmail");
		
		String[] address= req.getParameterValues("memberAddress");
		
		String memberAddress= null;
	    if(!address[0].equals("")) { 
	    	memberAddress = String.join(",,", address);
	    }else {
	    	memberAddress = "NULL";
	    }
	    
	    Member mem = new Member();
	    
	    mem.setMemberName(memberName);
	    mem.setMemberId(memberId);
	    mem.setMemberPw(memberPw);
	    mem.setMemberTel(memberTel);
	    mem.setMemberEmail(memberEmail);
	    mem.setMemberAddress(memberAddress);
	    
	    try {
	    	MemberService service = new MemberService();
	    	
	    	
	    	int result = service.signUp(mem);
	    	
	    	HttpSession session = req.getSession();
	    	
	    	if(result > 0) {
	    		session.setAttribute("message", "회원가입을 축하합니다.");
	    	}else {
	    		session.setAttribute("message", "회원가입이 실패되었습니다. 다시시도해주세요");
	    	}
//	    	resp.sendRedirect(req.getContextPath());
	    	resp.sendRedirect(req.getHeader("referer"));
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	
	}

}
