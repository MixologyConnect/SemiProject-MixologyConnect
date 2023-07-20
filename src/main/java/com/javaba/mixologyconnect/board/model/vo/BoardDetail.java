package com.javaba.mixologyconnect.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDetail {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private String modifyDate;
	private int readDate; // 조회수
	private String memberName;
	private String profileImage;
	private int memberNo;
	private String boardName;
	
}
