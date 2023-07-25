package edu.kh.community.cocktail.model.vo;

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
	private double alcohol;
	private double sugar;
	private String level;
	private int imageNo;

}
