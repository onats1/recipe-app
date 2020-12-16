package com.example.recipeapp.repositories

import com.example.recipeapp.domain.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository: CrudRepository<Category, Long> {
}