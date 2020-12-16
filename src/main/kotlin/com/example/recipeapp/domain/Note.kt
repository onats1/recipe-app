package com.example.recipeapp.domain

import javax.persistence.*

@Entity
data class Note (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @OneToOne
        var recipe: Recipe? = null,

        @Lob
        var recipeNotes: String
)