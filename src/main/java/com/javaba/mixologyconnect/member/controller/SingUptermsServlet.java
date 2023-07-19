package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/member/signUpterms")
public class SingUptermsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path ="/WEB-INF/views/member/signUpterms.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberName = req.getParameter("memberName");
		String memberId = req.getParameter("memberId");
	    String memberPw = req.getParameter("memberPw");
	    String memberTel = req.getParameter("memberTel");
	    String memberEmail = req.getParameter("memberEmail");
	    
	    //주소의 3개의 input으로 이루어져 있으므로 배열로 전달 받는다 
	    //-> DB에 컬럼은 1개 이므로 배열을 하나의 문자열로 합칠 예정 
	    String[] address = req.getParameterValues("memberAddress");
	
	    String memberAddress= null;
	    if(!address[0].equals("")) {//우편번호가 빈칸이 아니라면 == 주소가작성
	    	memberAddress = String.join(",,", address);
	    	
	    	// String.join ("구분자", 배열)
	    	// -> 배열 요소를 하나의 문자열로 반환
	    	//	요소 사이에 "구분자" 추가
	    }
	    
	    //파라미터로 하나의 member 객체에 저장
	    Member mem = new Member();
//	    mem.set
	
	
	}
}