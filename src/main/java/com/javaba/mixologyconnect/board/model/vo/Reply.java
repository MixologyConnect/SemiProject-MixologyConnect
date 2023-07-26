package com.javaba.mixologyconnect.board.model.vo;

import java.sql.Date;

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
	private Date replyDate;
	private int boardNo;
	private int memberNo;
	private String memberName;
	private String profileImage;
	
	
	
}
