package com.restaurant.ingredients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.ingredients.dto.IngredientRequest;
import com.restaurant.ingredients.model.Ingredient;
import com.restaurant.ingredients.service.IIngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	@Autowired
	private IIngredientService service;
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAllIngredients() {
		List<Ingredient> list = service.findAllIngredient();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<?> findIngredientById(
			@PathVariable Long id) {
		Ingredient i = service.findIngredientById(id);
		return ResponseEntity.ok().body(i);
	}
	
	@GetMapping("/find-by-name/{name}")
	public ResponseEntity<?> findIngredientByName(
			@PathVariable String name) {
		Ingredient i = service.findIngredientByName(name);
		return ResponseEntity.ok().body(i);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createIngredient(
			@RequestBody IngredientRequest request) throws Exception {
		Ingredient i = service.createIngredient(request);
		return ResponseEntity.ok().body(i);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> modifyIngredient(
			@PathVariable Long id,
			@RequestBody IngredientRequest request) {
		Ingredient i = service.modifyIngredient(id, request);
		return ResponseEntity.ok().body(i);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteIngredientById(
			@PathVariable Long id) {
		service.deleteIngredientById(id);
		return ResponseEntity.ok().body("Ingredient "+id+" successfully deleted");
	}
}
