package com.javaba.mixologyconnect.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor 
@AllArgsConstructor

public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberTel;
	private String memberName;
	private String memberAddress;
	private String memberEmail;
	private String profileImage;
	private String managerCode;
	private String secessionFlag;

}
