package com.javaba.mixologyconnect.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
	   
	   private int boardNo;
	   private String boardTitle;
	   private String memberName;
	   private String boardDate;
	   private int readDate; // 조회수
	   private String thumbnail;
	   
	   

}
