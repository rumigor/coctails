package ru.rumigor.drinks.data.model

import com.google.gson.annotations.SerializedName

data class Drinks(
    @SerializedName("drinks")
    val drinks: List<Drink>
)
