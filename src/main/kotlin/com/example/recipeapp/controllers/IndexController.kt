package com.example.recipeapp.controllers

import com.example.recipeapp.repositories.CategoryRepository
import com.example.recipeapp.repositories.UnitOfMeasureRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController
constructor(
        private val categoryRepository: CategoryRepository,
        private val unitOfMeasureRepository: UnitOfMeasureRepository
){

    @RequestMapping(value = ["", "/", "/index"])
    fun getIndexPage(): String{

        val categoryOptional = categoryRepository.findByDescription("American")
        val unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon")
        println("${categoryOptional.get().id}")
        println("${unitOfMeasure.get().id}")
        return "index"
    }


}