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
	   private String memberName;
	   private String BoardDate;
	   private int readCount; // 조회수
	   private String thumbnail;
	   private String boardContent;
	
	   
	   

}
