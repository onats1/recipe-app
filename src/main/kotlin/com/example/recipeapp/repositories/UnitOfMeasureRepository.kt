package com.example.recipeapp.repositories

import com.example.recipeapp.domain.UnitOfMeasure
import org.springframework.data.repository.CrudRepository

interface UnitOfMeasureRepository: CrudRepository<UnitOfMeasure, Long> {
}