package com.javaba.mixologyconnect.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.member.model.service.MemberService;
import com.javaba.mixologyconnect.member.model.vo.Member;

@WebServlet("/manager/manager/secession")
public class managerSecessionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		
		System.out.println(memberId);
		
		try {
			
			MemberService service = new MemberService();

			

<<<<<<< HEAD
			//member = service.managerSecession(memberId);
=======
			int result = service.managerSecession(memberId);
>>>>>>> 150334927151e68448244226afd817144fcb55fe

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
