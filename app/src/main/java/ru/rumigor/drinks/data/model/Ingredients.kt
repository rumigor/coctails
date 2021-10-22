package ru.rumigor.drinks.data.model

import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("drinks")
    val ingredients: List<Ingredient>
)