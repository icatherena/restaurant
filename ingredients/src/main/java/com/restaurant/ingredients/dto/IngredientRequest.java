package com.restaurant.ingredients.dto;

public class IngredientRequest {
	private String name;
	
	public IngredientRequest() {
	}

	public IngredientRequest(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
