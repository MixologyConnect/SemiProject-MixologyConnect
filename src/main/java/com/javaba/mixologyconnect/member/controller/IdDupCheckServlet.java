package com.javaba.mixologyconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/member/idDupCheck")
public class IdDupCheckServlet extends HttpServlet{

	// 아이디 중복 검사 (비동기 통신)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//비동기 통신 전달된 파라미터(date속성의 key값)얻어오기
		String memberId = req.getParameter("memberId");
		
		try {
			//이메일 중복검사 서비스 호출후 결과 반환 받기 
			MemberService  service = new MemberService();
			
			int result = service.idDupCheck(memberId);
			System.out.println(result);
			System.out.println(memberId);
			resp.getWriter().print(result);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}