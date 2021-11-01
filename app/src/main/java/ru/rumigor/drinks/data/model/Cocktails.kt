package ru.rumigor.drinks.data.model

import com.google.gson.annotations.SerializedName

data class Cocktails (
    @SerializedName("drinks")
    val drinks: List<Cocktail>
        )