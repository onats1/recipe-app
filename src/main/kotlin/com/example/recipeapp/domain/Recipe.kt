package com.example.recipeapp.domain

import javax.persistence.*

@Entity
data class Recipe(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Long? = null,
        private val description: String,
        private val prepTime: Int,
        private val cookTime: Int,
        private val servings: Int,
        private val source: String,
        private val url: String,
        private val directions: String,

        @ManyToMany
        @JoinTable(name = "recipe_category", joinColumns = [JoinColumn(name = "recipe_id")], inverseJoinColumns = [JoinColumn(name = "category_id")])
        private val categories: Set<Category>,

        @Enumerated(value = EnumType.STRING)
        private val difficulty: Difficulty,

        @OneToOne(cascade = [CascadeType.ALL])
        private val note: Note,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "recipe")
        private val ingredients: Set<Ingredient>,
        @Lob
        private val image: ByteArray
)