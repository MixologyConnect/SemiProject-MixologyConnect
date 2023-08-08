package com.javaba.mixologyconnect.chat.model.dao;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.javaba.mixologyconnect.chat.model.vo.Message;
import com.javaba.mixologyconnect.member.model.dao.MemberDAO;
import com.javaba.mixologyconnect.search.model.dao.SearchDAO;

public class ChatDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public ChatDAO() {
		try {
			prop = new Properties();
			String filePath = SearchDAO.class.getResource("/com/javaba/mixologyconnect/sql/chat-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Message> receiveMessages(Connection conn, int receiver, Timestamp time) throws Exception {
		List<Message> messages = new ArrayList<Message>();
		MemberDAO dao = new MemberDAO();

		try {
			pstmt = conn.prepareStatement(prop.getProperty("receiveMessages"));
			pstmt.setInt(1, receiver);
			pstmt.setTimestamp(2, time);
			rs = pstmt.executeQuery();
			while (rs.next()) 
				if (receiver == 0) messages.add(new Message(dao.selectMember(conn, "MEMBER_NO", rs.getInt("SENDER") + "").get(0),
														    null,
														    rs.getString("MESSAGE"),
														    rs.getTimestamp("SENT_TIMESTAMP")));
				else messages.add(new Message(dao.selectMember(conn, "MEMBER_NO", rs.getInt("SENDER") + "").get(0),
										      dao.selectMember(conn, "MEMBER_NO", receiver + "").get(0),
										      rs.getString("MESSAGE"),
										      rs.getTimestamp("SENT_TIMESTAMP")));
			} finally {
			close(pstmt);
			close(rs);
		}

		return messages;
	}

	public int sendMessage(Connection conn, int sender, String message) throws Exception {
		int result;

		try {
			pstmt = conn.prepareStatement(prop.getProperty("sendMessage"));
			pstmt.setInt(1, sender);
			pstmt.setString(2, message);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}

		return result;
	}
}
