package com.restaurant.recipes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RecipeConfig {
	@Bean("fetchAPI")
	public RestTemplate signRestTemplate() {
		return new RestTemplate();
	}
}
