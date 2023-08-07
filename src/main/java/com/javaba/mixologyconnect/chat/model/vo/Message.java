package com.javaba.mixologyconnect.chat.model.vo;

import com.javaba.mixologyconnect.member.model.vo.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Message {
	private Member sender;
	private Member receiver;
	private String message;
	private String sentTime;
}
