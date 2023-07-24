package com.javaba.mixologyconnect.board.model.vo;

import java.util.List;

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
	private int readCount; // 조회수
	private String memberName;
	private String profileImage;
	private int memberNo;
	private String boardName;
	
	private List<BoardImage> imageList;
	
}
