package com.javaba.mixologyconnect.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.member.model.service.MemberService;

@WebServlet("/manager/member/upgrade")
public class memberUpgradeServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		
		try {
			
			MemberService service = new MemberService();
			
			int result = service.memberUpgrade(memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
