package ru.rumigor.drinks.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cocktails")
data class Cocktail(
    @PrimaryKey
    @SerializedName("idDrink")
    val idDrink: String,
    @ColumnInfo(name = "strDrink")
    @SerializedName("strDrink")
    val strDrink: String,
    @ColumnInfo(name = "avatar")
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String
)
