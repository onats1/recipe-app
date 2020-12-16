package com.example.recipeapp.repositories

import com.example.recipeapp.domain.UnitOfMeasure
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UnitOfMeasureRepository: CrudRepository<UnitOfMeasure, Long> {

    fun findByDescription(description: String): Optional<UnitOfMeasure>
}