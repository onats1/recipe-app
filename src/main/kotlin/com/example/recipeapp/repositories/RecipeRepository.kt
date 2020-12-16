package com.example.recipeapp.repositories

import com.example.recipeapp.domain.Recipe
import org.springframework.data.repository.CrudRepository

interface RecipeRepository: CrudRepository<Recipe, Long> {
}