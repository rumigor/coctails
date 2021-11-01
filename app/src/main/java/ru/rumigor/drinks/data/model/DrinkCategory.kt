package ru.rumigor.drinks.data.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class DrinkCategory(
    @PrimaryKey
    @SerializedName ("strCategory")
    val strCategory: String
)
