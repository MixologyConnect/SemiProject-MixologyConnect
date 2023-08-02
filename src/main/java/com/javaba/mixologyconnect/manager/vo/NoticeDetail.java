package com.javaba.mixologyconnect.manager.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeDetail {

	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private int imageNo;
}
