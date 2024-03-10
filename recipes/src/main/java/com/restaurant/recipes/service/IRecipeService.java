package com.restaurant.recipes.service;

import java.util.List;

import com.restaurant.recipes.dto.RecipeRequest;
import com.restaurant.recipes.model.Recipe;

public interface IRecipeService {
	public Recipe findRecipe(Long id);
	public List<Recipe> findAllRecipes();
	public Recipe createRecipe(RecipeRequest r);
	public Recipe modifyRecipe(Long id, RecipeRequest r);
	public void deleteRecipe(Long id);
}
