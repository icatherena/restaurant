package com.restaurant.recipes.service.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.recipes.dto.RecipeRequest;
import com.restaurant.recipes.enums.CodeError;
import com.restaurant.recipes.exception.NotFoundException;
import com.restaurant.recipes.mapper.RecipeMapper;
import com.restaurant.recipes.model.Recipe;
import com.restaurant.recipes.repository.IRecipeRepository;
import com.restaurant.recipes.service.IRecipeService;

@Service
public class RecipeServiceImpl implements IRecipeService {

	@Autowired
	private IRecipeRepository repository;
	
	@Autowired
	private MessageSource message;
	
	@Autowired
	private RecipeMapper mapper;
	
	//ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Recipe findRecipe(Long id) {
		Recipe r = repository.findById(id).orElse(null);
		if (r == null) {
			throw new NotFoundException(message.getMessage(
	    			CodeError.NOT_FOUND_RECIPE.toString(), null, Locale.US));
		}
		return r;
	}

	@Override
	public List<Recipe> findAllRecipes() {
		return repository.findAll();
	}

	@Override
	public Recipe createRecipe(RecipeRequest r) {
		Recipe recipe = mapper.toRecipeEntity(r, null);
		repository.save(recipe);
		return recipe;
	}

	@Override
	public Recipe modifyRecipe(Long id, RecipeRequest r) {
		Recipe recipe = repository.findByRecipeNumber(id);
		if (recipe == null) {
			throw new NotFoundException(message.getMessage(
	    			CodeError.NOT_FOUND_RECIPE.toString(), null, Locale.US));
		}
		recipe = mapper.toRecipeEntity(r, recipe);
		repository.save(recipe);
		return recipe;
	}

	@Override
	public void deleteRecipe(Long id) {
		Recipe r = repository.findByRecipeNumber(id);
		if (r == null) {
			throw new NotFoundException(message.getMessage(
	    			CodeError.NOT_FOUND_RECIPE.toString(), null, Locale.US));
		}
		repository.deleteById(r.getRecipeNumber());
	}

}
