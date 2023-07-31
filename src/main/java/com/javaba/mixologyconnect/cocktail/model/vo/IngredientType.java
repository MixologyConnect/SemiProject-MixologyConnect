package com.javaba.mixologyconnect.cocktail.model.vo;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IngredientType {

	public static Map<String, IngredientType> maps = new HashMap<String, IngredientType>();
	private int no;
	private String name;
	private String imagePath;

	public IngredientType() {}

	public IngredientType(int no, String name, String imagePath) {
		this.no = no;
		this.name = name;
		this.imagePath = imagePath;
	}

}