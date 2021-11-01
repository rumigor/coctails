package ru.rumigor.drinks.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ingredients")
data class Ingredient(
    @PrimaryKey
    @SerializedName("strIngredient1")
    val strIngredient1: String,
    @SerializedName("checked")
    val checked: Boolean = false
)