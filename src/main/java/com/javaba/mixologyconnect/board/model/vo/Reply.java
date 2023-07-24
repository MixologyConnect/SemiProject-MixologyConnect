package com.javaba.mixologyconnect.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reply {

	private int replyNo;
	private String replyContent;
	private String boardDate;
	private int boardNo;
	private int memberNo;
	private String memberName;
	private String profileImage;
	
	
	
}
