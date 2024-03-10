package com.restaurant.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.recipes.model.Recipe;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, Long>{

	@Query(value = "SELECT r "
			+ "FROM Recipe AS r "
			+ "WHERE r.recipeNumber = :id")
	Recipe findByRecipeNumber(@Param("id") Long id);

}
