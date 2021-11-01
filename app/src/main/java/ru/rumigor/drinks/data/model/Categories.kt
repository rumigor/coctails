package ru.rumigor.drinks.data.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("drinks")
    val drinkCategories: List<DrinkCategory>
)
