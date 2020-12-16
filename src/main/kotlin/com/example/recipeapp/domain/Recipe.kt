package com.example.recipeapp.domain

import javax.persistence.*

@Entity
data class Recipe(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var description: String? = null,
        var prepTime: Int? = null,
        var cookTime: Int? = null,
        var servings: Int? = null,
        var source: String? = null,
        var url: String? = null,

        @Lob
        var directions: String? = null,

        @ManyToMany
        @JoinTable(name = "recipe_category", joinColumns = [JoinColumn(name = "recipe_id")], inverseJoinColumns = [JoinColumn(name = "category_id")])
        var categories: Set<Category> = setOf(),

        @Enumerated(value = EnumType.STRING)
        var difficulty: Difficulty? = null,

        @OneToOne(cascade = [CascadeType.ALL])
        var note: Note? = null,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "recipe")
        var ingredients: Set<Ingredient> = setOf(),

        @Lob
        var image: ByteArray? = null
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Recipe

                if (id != other.id) return false
                if (description != other.description) return false
                if (prepTime != other.prepTime) return false
                if (cookTime != other.cookTime) return false
                if (servings != other.servings) return false
                if (source != other.source) return false
                if (url != other.url) return false
                if (directions != other.directions) return false
                if (categories != other.categories) return false
                if (difficulty != other.difficulty) return false
                if (note != other.note) return false
                if (ingredients != other.ingredients) return false
                if (image != null) {
                        if (other.image == null) return false
                        if (!image!!.contentEquals(other.image!!)) return false
                } else if (other.image != null) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (description?.hashCode() ?: 0)
                result = 31 * result + (prepTime ?: 0)
                result = 31 * result + (cookTime ?: 0)
                result = 31 * result + (servings ?: 0)
                result = 31 * result + (source?.hashCode() ?: 0)
                result = 31 * result + (url?.hashCode() ?: 0)
                result = 31 * result + (directions?.hashCode() ?: 0)
                result = 31 * result + categories.hashCode()
                result = 31 * result + (difficulty?.hashCode() ?: 0)
                result = 31 * result + (note?.hashCode() ?: 0)
                result = 31 * result + ingredients.hashCode()
                result = 31 * result + (image?.contentHashCode() ?: 0)
                return result
        }
}