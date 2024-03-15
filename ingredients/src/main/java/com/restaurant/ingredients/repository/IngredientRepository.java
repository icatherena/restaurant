package com.restaurant.ingredients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.ingredients.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

	@Query(value = "SELECT i "
			+ "FROM Ingredient AS i "
			+ "WHERE i.name = :name")
	Ingredient findByName(@Param("name") String name);

}
