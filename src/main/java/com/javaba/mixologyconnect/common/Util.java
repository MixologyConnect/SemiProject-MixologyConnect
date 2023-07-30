package com.javaba.mixologyconnect.common;

public class Util {


		// 개행문자 -> <br> 변경 메서드
		public static String newLineHandling(String content) {
			
			return content.replaceAll("\r\n|\n|\r|\n\r", "<br>");
			
			// textarea의 엔터 : \r\n
			// \r : 캐리지 리턴 (첫 번째로 돌아가기) -> 현재는 개행문자로 인식
			// \n : new line(다음 줄로 이동)
			
		}
		
		// XSS : 관리자가 아닌 이용자가 악성 스크립트를 삽입해서 공격
		
		// Cross site Scripting(XSS, 크로스 사이트 스크립팅) 공격
		public static String XSSHandling(String content) {
			// <, >, &, " 문자를 HTML 코듣가 아닌 문자 그대로 보이도록 변경

			if(content != null) {
				content = content.replaceAll("&", "&amp;"); 
				content = content.replaceAll("<", "&lt;"); 
				content = content.replaceAll(">", "&gt;"); 
				content = content.replaceAll("\"", "&quot;");
				
			}
			return content;
		}
				
		
	}

