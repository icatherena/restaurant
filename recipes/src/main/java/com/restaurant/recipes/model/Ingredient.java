package com.restaurant.recipes.model;

import java.util.List;

public class Ingredient {
	
	private Long id;
	private String name;
	
	public Ingredient() {
		super();
	}

	public Ingredient(Long id, String name, List<Recipe> itemRecipe) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + "]";
	}
	
}
