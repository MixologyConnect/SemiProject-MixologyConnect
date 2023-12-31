package com.javaba.mixologyconnect.myPage.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookMark {

	  private int boardNo;
	   private String boardTitle;
	   private String memberName;
	   private String createDate;
	   private int readCount; // 조회수
	
}
