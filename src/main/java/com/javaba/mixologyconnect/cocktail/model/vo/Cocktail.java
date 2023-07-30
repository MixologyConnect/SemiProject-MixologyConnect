package com.javaba.mixologyconnect.cocktail.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Cocktail {

	private int cocktailNo;
	private String cocktailName;
	private String cocktailContent;
	private char alcohol;
	private char sugar;
	private String difficulty;
	private String imagePath;

}
