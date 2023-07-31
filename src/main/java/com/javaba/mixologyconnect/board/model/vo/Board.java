package com.javaba.mixologyconnect.board.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
	   
	   private int boardNo;
	   private String boardTitle;
	   private String boardContent;
	   private String BoardDate;
	   private String memberName;
	   private int readCount; // 조회수
	   private String thumbnail;
	
	   
	   

}
