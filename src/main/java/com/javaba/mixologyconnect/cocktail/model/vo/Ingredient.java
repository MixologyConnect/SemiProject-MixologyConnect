package com.javaba.mixologyconnect.cocktail.model.vo;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ingredient {

	public static Map<String, Ingredient> maps = new HashMap<String, Ingredient>();
	private int no;
	private String name;
	private IngredientType type; // 집합 관계

	public Ingredient() {}

	public Ingredient(int no, String name, IngredientType type) {
		this.no = no;
		this.name = name;
		this.type = type;
	}

}
