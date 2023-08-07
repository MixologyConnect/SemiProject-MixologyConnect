package com.javaba.mixologyconnect.chat.model.vo;

import java.sql.Timestamp;

import com.javaba.mixologyconnect.member.model.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	private Member sender;
	private Member receiver;
	private String message;
	private Timestamp sentTime;
}
