package com.example.recipeapp.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Ingredient (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var description: String? = null,
        var amount: BigDecimal? = null,

        @ManyToOne
        var recipe: Recipe? = null,

        @OneToOne(fetch = FetchType.EAGER)
        var unitOfMeasure: UnitOfMeasure? = null
){
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Ingredient

                if (id != other.id) return false
                if (description != other.description) return false
                if (amount != other.amount) return false
                if (recipe != other.recipe) return false
                if (unitOfMeasure != other.unitOfMeasure) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (description?.hashCode() ?: 0)
                result = 31 * result + (amount?.hashCode() ?: 0)
                result = 31 * result + (recipe?.hashCode() ?: 0)
                result = 31 * result + (unitOfMeasure?.hashCode() ?: 0)
                return result
        }
}