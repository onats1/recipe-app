package com.example.recipeapp.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Ingredient (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Long? = null,
        private val description: String,
        private val amount: BigDecimal,

        @ManyToOne
        private val recipe: Recipe,

        @OneToOne(fetch = FetchType.EAGER)
        private val unitOfMeasure: UnitOfMeasure
)