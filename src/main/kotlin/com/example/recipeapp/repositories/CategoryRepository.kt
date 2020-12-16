package com.example.recipeapp.repositories

import com.example.recipeapp.domain.Category
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CategoryRepository: CrudRepository<Category, Long> {

    fun findByDescription(description: String): Optional<Category>
}