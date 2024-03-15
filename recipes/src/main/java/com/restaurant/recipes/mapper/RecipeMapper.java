package com.restaurant.recipes.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.restaurant.recipes.dto.RecipeRequest;
import com.restaurant.recipes.model.Ingredient;
import com.restaurant.recipes.model.Recipe;

@Component
public class RecipeMapper {

	@Autowired
	private RestTemplate fetchAPI; // Same label used in bean configuration

	public Recipe toRecipeEntity(RecipeRequest r, Recipe alreadyPersisted) {
		Recipe recipe = new Recipe();

		if (alreadyPersisted == null) {
			
			recipe.setRecipeName(r.getRecipeName());
			recipe.setPrice(r.getPrice());
			recipe.setDescription(r.getDescription());

			List<String> ingredientList = new ArrayList<String>();

			for (String ingredient : r.getIngredients()) {
				Ingredient ingredientPersisted = fetchAPI
						.getForObject("http://localhost:9002/ingredients/find-by-name/" + ingredient, Ingredient.class);
				if (ingredientPersisted == null) {
					ingredientPersisted = new Ingredient();
					ingredientPersisted.setName(ingredient);
					fetchAPI.postForObject("http://localhost:9002/ingredients/create", ingredientPersisted, Ingredient.class);
				}
				ingredientList.add(ingredientPersisted.getName());
			}
			recipe.setIngredients(ingredientList);
			
		} else {
			
			String name = (r.getRecipeName() != null) ? r.getRecipeName() : alreadyPersisted.getRecipeName();
			recipe.setRecipeName(name);
			
			Double price = (r.getPrice() != null) ? r.getPrice() : alreadyPersisted.getPrice();
			recipe.setPrice(price);
			
			String description = (r.getDescription() != null) ? r.getDescription() : alreadyPersisted.getDescription();
			recipe.setDescription(description);

			List<String> ingredientList = new ArrayList<String>();
			List<String> ingredientInRecipe = alreadyPersisted.getIngredients();

			if (r.getIngredients() != null) {
				for (String ingredient : r.getIngredients()) {
					Ingredient ingredientPersisted = fetchAPI.getForObject(
							"http://localhost:9002/ingredients/find-by-name/" + ingredient, Ingredient.class);
					if (ingredientPersisted == null) {
						ingredientPersisted = new Ingredient();
						ingredientPersisted.setName(ingredient);
						fetchAPI.postForObject("http://localhost:9002/ingredients/create", ingredientPersisted, Ingredient.class);
					}
					ingredientList.add(ingredientPersisted.getName());
				}
				for (String p : ingredientList) {
					if (!ingredientInRecipe.contains(p)) {
						ingredientInRecipe.add(p);
					}
				}
				recipe.setIngredients(ingredientInRecipe);
			} else {
				recipe.setDescription(alreadyPersisted.getDescription());
			}
			
		}
		return recipe;
	}
}
