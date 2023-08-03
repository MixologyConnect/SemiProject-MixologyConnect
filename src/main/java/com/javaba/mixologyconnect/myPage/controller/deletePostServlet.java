package com.javaba.mixologyconnect.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaba.mixologyconnect.myPage.model.service.MypageService;

@WebServlet("/myPage/deletePost")
public class deletePostServlet extends HttpServlet {
	
	 public static String removeLastChar(String str) {
	        if (str == null || str.length() == 0) {
	            return str;
	        }
	        return str.substring(0, str.length() - 1);
	    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MypageService service = new MypageService();
			
			String[] arr = req.getParameterValues("result");
			System.out.println("배열값 : " +  arr.length);
			
			StringBuilder result1 = new StringBuilder("");
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + ",");
				
				
				
			}
			
			int result = service.deletePost(arr);
			
			// ajax로 값 보내주기 ( 0 or 1) 결과 반환
			resp.getWriter().print(result);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
