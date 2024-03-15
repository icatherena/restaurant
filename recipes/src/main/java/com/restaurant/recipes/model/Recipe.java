package com.restaurant.recipes.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recipeNumber;
	private String recipeName;
	private Double price;
	private String description;
	
//	@ManyToMany
//	@JoinTable(name = "recipe_ingredient",
//			joinColumns = @JoinColumn(name = "recipe_id"),
//	        inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
//	private List<Ingredient> ingredients;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> ingredients;
	
	public Recipe() {
		super();
	}

	public Recipe(Long recipeNumber, String recipeName, Double price, String description, 
			List<String> ingredients) {
		super();
		this.recipeNumber = recipeNumber;
		this.recipeName = recipeName;
		this.price = price;
		this.description = description;
		this.ingredients = ingredients;
	}

	public Long getRecipeNumber() {
		return recipeNumber;
	}

	public void setRecipeNumber(Long recipeNumber) {
		this.recipeNumber = recipeNumber;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
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

	@Override
	public String toString() {
		return "Dish [recipeNumber=" + recipeNumber + ", recipeName=" + recipeName + ", price=" + price + ", description="
				+ description + ", ingredients=" + ingredients + "]";
	}
	
}
