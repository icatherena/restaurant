package com.restaurant.ingredients.service;

import java.util.List;

import com.restaurant.ingredients.dto.IngredientRequest;
import com.restaurant.ingredients.model.Ingredient;

public interface IIngredientService {
	public List<Ingredient> findAllIngredient();
	public Ingredient findIngredientById(Long id);
	public Ingredient findIngredientByName(String name);
	public Ingredient createIngredient(IngredientRequest r) throws Exception;
	public Ingredient modifyIngredient(Long id, IngredientRequest r);
	public void deleteIngredientById(Long id);
}
