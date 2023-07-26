package com.javaba.mixologyconnect.column.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor


public class Column {
	
	
	private int boardNo;
	private String boardTitle;
	private String memberName;
	private String BoardDate;
	private int readCount; // 조회수
	private String thumbnail;

}
