package com.javaba.mixologyconnect.chat.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.google.gson.JsonElement;
import com.javaba.mixologyconnect.chat.model.dao.ChatDAO;
import com.javaba.mixologyconnect.chat.model.vo.Message;

public class ChatService {

	private ChatDAO dao = new ChatDAO();

	public List<Message> receiveMessages(int receiver, Timestamp time) throws Exception {
		Connection conn = getConnection();
		List<Message> messages = dao.receiveMessages(conn, receiver, time);
		close(conn);
		return messages;
	}

	public int sendMessage(int sender, String message) throws Exception {
		Connection conn = getConnection();

		int result = dao.sendMessage(conn, sender, message);
		if (result > 0) commit(conn);
	   	else rollback(conn);

		close(conn);
		return result;
	}

}
