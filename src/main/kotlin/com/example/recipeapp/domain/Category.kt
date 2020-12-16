package com.example.recipeapp.domain

import javax.persistence.*

@Entity
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val description: String,

        @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
        val recipes: Set<Recipe> = setOf()
)