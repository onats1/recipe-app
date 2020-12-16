package com.example.recipeapp.domain

import javax.persistence.*

@Entity
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Long? = null,
        private val description: String,

        @ManyToMany(mappedBy = "categories")
        private val recipes: Set<Recipe>
)