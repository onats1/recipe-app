package com.example.recipeapp.bootstrap

import com.example.recipeapp.domain.Difficulty
import com.example.recipeapp.domain.Ingredient
import com.example.recipeapp.domain.Note
import com.example.recipeapp.domain.Recipe
import com.example.recipeapp.repositories.CategoryRepository
import com.example.recipeapp.repositories.RecipeRepository
import com.example.recipeapp.repositories.UnitOfMeasureRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class RecipeBootStrap
constructor(
        private val categoryRepository: CategoryRepository,
        private val recipeRepository: RecipeRepository,
        private val unitOfMeasureRepository: UnitOfMeasureRepository
) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes())
    }

    private fun getRecipes(): List<Recipe> {

        val eachOptional = if (unitOfMeasureRepository.findByDescription("Each").isPresent) {
            unitOfMeasureRepository.findByDescription("Each").get()
        } else {
            throw RuntimeException("Expected UOM not found.")
        }

        val tableSpoonOptional = if (unitOfMeasureRepository.findByDescription("Tablespoon").isPresent) {
            unitOfMeasureRepository.findByDescription("Tablespoon").get()
        } else {
            throw RuntimeException("Expected UOM not found.")
        }

        val teaSpoonOptional = if (unitOfMeasureRepository.findByDescription("Teaspoon").isPresent) {
            unitOfMeasureRepository.findByDescription("Teaspoon").get()
        } else {
            throw RuntimeException("Expected UOM not found.")
        }

        val cupOptional = if (unitOfMeasureRepository.findByDescription("Cup").isPresent) {
            unitOfMeasureRepository.findByDescription("Cup").get()
        } else {
            throw RuntimeException("Expected UOM not found.")
        }

        val ounceOptional = if (unitOfMeasureRepository.findByDescription("Ounce").isPresent) {
            unitOfMeasureRepository.findByDescription("Ounce").get()
        } else {
            throw RuntimeException("Expected UOM not found.")
        }

        val pinchOptional = if (unitOfMeasureRepository.findByDescription("Pinch").isPresent) {
            unitOfMeasureRepository.findByDescription("Pinch").get()
        } else {
            throw RuntimeException("Expected UOM not found.")
        }

        val pintOptional = if (unitOfMeasureRepository.findByDescription("Pint").isPresent) {
            unitOfMeasureRepository.findByDescription("Pint").get()
        } else {
            throw RuntimeException("Expected UOM not found.")
        }

        val dashOptional = if (unitOfMeasureRepository.findByDescription("Dash").isPresent) {
            unitOfMeasureRepository.findByDescription("Dash").get()
        } else {
            throw RuntimeException("Expected UOM not found.")
        }

        val mexicanCategory = if (categoryRepository.findByDescription("Mexican").isPresent) {
            categoryRepository.findByDescription("Mexican").get()
        } else {
            throw RuntimeException("Expected category not found.")
        }

        val americanCategory = if (categoryRepository.findByDescription("American").isPresent) {
            categoryRepository.findByDescription("Mexican").get()
        } else {
            throw RuntimeException("Expected category not found.")
        }

        val italianCategory = if (categoryRepository.findByDescription("Italian").isPresent) {
            categoryRepository.findByDescription("Italian").get()
        } else {
            throw RuntimeException("Expected category not found.")
        }

        val fastFoodCategory = if (categoryRepository.findByDescription("FastFood").isPresent) {
            categoryRepository.findByDescription("FastFood").get()
        } else {
            throw RuntimeException("Expected category not found.")
        }

        val chickenTikkaMasala = Recipe()
        chickenTikkaMasala.description = "This easy chicken tikka masala recipe calls for a number of spices, but they all add to the characteristic deep flavors. " +
                "This recipe is worth the raid on your spice cupboard."
        chickenTikkaMasala.note = Note(recipeNotes = "Yes! You can make the chicken up to 2 days ahead of time. Cover and refrigerate it. Dishes like this improve when the flavors have a chance to meld.\n" +
                "\n" +
                "Chicken Tikka Masala will freeze up to two months. Store in large, zip-top freezer bags and lay them flat in the freezer.\n" +
                "\n" +
                "My husband gave this chicken tikka masala recipe his seal of approval. I hope you like it too!", recipe = chickenTikkaMasala)
        chickenTikkaMasala.difficulty = Difficulty.HARD
        chickenTikkaMasala.directions = "Make this tikka masala in just a few (easy!) steps—the whole dish is ready in under 45 minutes!\n" +
                "\n" +
                "Marinate the chicken with yogurt. This tenderizes the chicken and adds flavor.\n" +
                "Cook the chicken.\n" +
                "Make the masala sauce. This involves simmering onions, spices, and tomatoes, with a little yogurt added at the end for creaminess and tangy flavor.\n" +
                "Combine the sauce and the chicken. And you’re done!"
        chickenTikkaMasala.cookTime = 345
        val chickenIngredient = Ingredient(description = "boneless chicken", unitOfMeasure = pinchOptional,
                amount = 1.25.toBigDecimal())
        chickenTikkaMasala.ingredients.plus(chickenIngredient)
        chickenTikkaMasala.categories = setOf(americanCategory, mexicanCategory)

        return listOf(chickenTikkaMasala)
    }


}