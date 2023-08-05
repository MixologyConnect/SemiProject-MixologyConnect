package com.javaba.mixologyconnect.cocktail.model.vo;

import java.util.Map;

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
public class CocktailThumbnail {

	private int cocktailNo;
	private String cocktailName;
	private String imagePath;

}
