package com.restaurant.recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.recipes.dto.RecipeRequest;
import com.restaurant.recipes.model.Recipe;
import com.restaurant.recipes.service.IRecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private IRecipeService service;
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAllRecipes() {
		List<Recipe> r = service.findAllRecipes();
		return ResponseEntity.ok().body(r);
	}
	
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<?> findRecipe(@PathVariable Long id) {
		Recipe r = service.findRecipe(id);
		return ResponseEntity.ok().body(r);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createRecipe(@RequestBody RecipeRequest request) {
		Recipe r = service.createRecipe(request);
		return ResponseEntity.ok().body(r);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> modifyRecipe(@RequestBody RecipeRequest request, @PathVariable Long id) {
//		Recipe r = service.modifyRecipe(id, request);
//		return ResponseEntity.ok().body(r);
		service.modifyRecipe(id, request);
		return ResponseEntity.ok().body("Recipe "+id+" successfully modified");
	}
	
	public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
		service.deleteRecipe(id);
		return ResponseEntity.ok().body("Recipe "+id+" successfully deleted");
	}
}
