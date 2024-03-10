package com.restaurant.recipes.dto;

import java.util.List;

public class RecipeRequest {
	private Double price;
	private String description;
	private List<String> ingredients;
	
	public RecipeRequest() {
		super();
	}
	
	public RecipeRequest(Double price, String description, List<String> ingredients) {
		super();
		this.price = price;
		this.description = description;
		this.ingredients = ingredients;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
