package ru.rumigor.drinks.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "drinks")
data class Drink(
    @PrimaryKey
    @SerializedName("idDrink")
    val idDrink: String,
    @ColumnInfo(name = "strDrink")
    @SerializedName("strDrink")
    val strDrink: String,
    @ColumnInfo(name = "strAlcoholic")
    @SerializedName("strAlcoholic")
    val strAlcoholic: String,
    @ColumnInfo(name = "strInstructions")
    @SerializedName("strInstructions")
    val strInstructions: String,
    @ColumnInfo(name = "avatar")
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String,
//    @ColumnInfo(name = "strIngredient1")
//    @SerializedName("strIngredient1")
//    val strIngredient1: String,
//    @ColumnInfo(name = "strIngredient2")
//    @SerializedName("strIngredient2")
//    val strIngredient2: String,
//    @ColumnInfo(name = "strIngredient3")
//    @SerializedName("strIngredient3")
//    val strIngredient3: String,
//    @ColumnInfo(name = "strIngredient4")
//    @SerializedName("strIngredient4")
//    val strIngredient4: String,
//    @ColumnInfo(name = "strIngredient5")
//    @SerializedName("strIngredient5")
//    val strIngredient5: String,
//    @ColumnInfo(name = "strIngredient6")
//    @SerializedName("strIngredient6")
//    val strIngredient6: String,
//    @ColumnInfo(name = "strIngredient7")
//    @SerializedName("strIngredient7")
//    val strIngredient7: String,
//    @ColumnInfo(name = "strIngredient8")
//    @SerializedName("strIngredient8")
//    val strIngredient8: String,
//    @ColumnInfo(name = "strIngredient9")
//    @SerializedName("strIngredient9")
//    val strIngredient9: String,
//    @ColumnInfo(name = "strIngredient10")
//    @SerializedName("strIngredient10")
//    val strIngredient10: String,
//    @ColumnInfo(name = "strIngredient11")
//    @SerializedName("strIngredient11")
//    val strIngredient11: String,
//    @ColumnInfo(name = "strIngredient12")
//    @SerializedName("strIngredient12")
//    val strIngredient12: String,
//    @ColumnInfo(name = "strIngredient13")
//    @SerializedName("strIngredient2")
//    val strIngredient13: String,
//    @ColumnInfo(name = "strIngredient14")
//    @SerializedName("strIngredient14")
//    val strIngredient14: String,
//    @ColumnInfo(name = "strIngredient15")
//    @SerializedName("strIngredient15")
//    val strIngredient15: String

)