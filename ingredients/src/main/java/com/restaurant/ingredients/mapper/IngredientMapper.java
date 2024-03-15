package com.restaurant.ingredients.mapper;

import org.springframework.stereotype.Component;

import com.restaurant.ingredients.dto.IngredientRequest;
import com.restaurant.ingredients.model.Ingredient;

@Component
public class IngredientMapper {
	public Ingredient toEntity(IngredientRequest r) {
		Ingredient i = new Ingredient();
		i.setName(r.getName());
		return i;
	}
}
