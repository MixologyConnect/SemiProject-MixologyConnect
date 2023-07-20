package com.javaba.mixologyconnect.member.model.dao;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.nio.file.ClosedDirectoryStreamException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.javaba.mixologyconnect.member.model.vo.Member;


public class MemberDAO {

	private Statement stmt; 
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
	public MemberDAO() {
		
		try {
			
			prop = new Properties();
			
			String filePath =  MemberDAO.class.getResource("/edu/kh/community/sql/member-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**@author 이지영
	 * 회원가입 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member mem)throws Exception {
		int result = 0;
		
		try {
			String sql =prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberName());
			pstmt.setString(2, mem.getMemberId());
			pstmt.setString(3, mem.getMemberPw());
			pstmt.setString(4, mem.getMemberTel());
			pstmt.setString(5, mem.getMemberEmail());
			pstmt.setString(6, mem.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);	
		}
		return result;
	}
}