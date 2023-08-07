package com.javaba.mixologyconnect.chat.model.service;

import static com.javaba.mixologyconnect.common.JDBCTemplate.*;

import java.util.List;

import com.javaba.mixologyconnect.chat.model.dao.ChatDAO;
import com.javaba.mixologyconnect.chat.model.vo.Message;

public class ChatService {

	private ChatDAO dao = new ChatDAO();

	public List<Message> receiveMessages(int sender, long time) throws Exception {
		
		return
	}

}
