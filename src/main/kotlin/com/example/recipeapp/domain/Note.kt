package com.example.recipeapp.domain

import javax.persistence.*

@Entity
data class Note (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Long? = null,

        @OneToOne
        private val recipe: Recipe,
        @Lob
        private val recipeNotes: String
)