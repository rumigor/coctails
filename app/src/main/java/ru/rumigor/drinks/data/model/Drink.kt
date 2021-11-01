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
    val strAlcoholic: String?,
    @ColumnInfo(name = "strInstructions")
    @SerializedName("strInstructions")
    val strInstructions: String?,
    @ColumnInfo(name = "avatar")
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String,
    @ColumnInfo(name = "drinkCategory")
    @SerializedName("strCategory")
    val strCategory: String?,
    @ColumnInfo(name = "strIngredient1")
    @SerializedName("strIngredient1")
    val strIngredient1: String?,
    @ColumnInfo(name = "strIngredient2")
    @SerializedName("strIngredient2")
    val strIngredient2: String?,
    @ColumnInfo(name = "strIngredient3")
    @SerializedName("strIngredient3")
    val strIngredient3: String?,
    @ColumnInfo(name = "strIngredient4")
    @SerializedName("strIngredient4")
    val strIngredient4: String?,
    @ColumnInfo(name = "strIngredient5")
    @SerializedName("strIngredient5")
    val strIngredient5: String?,
    @ColumnInfo(name = "strIngredient6")
    @SerializedName("strIngredient6")
    val strIngredient6: String?,
    @ColumnInfo(name = "strIngredient7")
    @SerializedName("strIngredient7")
    val strIngredient7: String?,
    @ColumnInfo(name = "strIngredient8")
    @SerializedName("strIngredient8")
    val strIngredient8: String?,
    @ColumnInfo(name = "strIngredient9")
    @SerializedName("strIngredient9")
    val strIngredient9: String?,
    @ColumnInfo(name = "strIngredient10")
    @SerializedName("strIngredient10")
    val strIngredient10: String?,
    @ColumnInfo(name = "strIngredient11")
    @SerializedName("strIngredient11")
    val strIngredient11: String?,
    @ColumnInfo(name = "strIngredient12")
    @SerializedName("strIngredient12")
    val strIngredient12: String?,
    @ColumnInfo(name = "strIngredient13")
    @SerializedName("strIngredient13")
    val strIngredient13: String?,
    @ColumnInfo(name = "strIngredient14")
    @SerializedName("strIngredient14")
    val strIngredient14: String?,
    @ColumnInfo(name = "strIngredient15")
    @SerializedName("strIngredient15")
    val strIngredient15: String?,
    @ColumnInfo(name = "strMeasure1")
    @SerializedName("strMeasure1")
    val strMeasure1: String?,
    @ColumnInfo(name = "strMeasure2")
    @SerializedName("strMeasure2")
    val strMeasure2: String?,
    @ColumnInfo(name = "strMeasure3")
    @SerializedName("strMeasure3")
    val strMeasure3: String?,
    @ColumnInfo(name = "strMeasure4")
    @SerializedName("strMeasure4")
    val strMeasure4: String?,
    @ColumnInfo(name = "strMeasure5")
    @SerializedName("strMeasure5")
    val strMeasure5: String?,
    @ColumnInfo(name = "strMeasure6")
    @SerializedName("strMeasure6")
    val strMeasure6: String?,
    @ColumnInfo(name = "strMeasure7")
    @SerializedName("strMeasure7")
    val strMeasure7: String?,
    @ColumnInfo(name = "strMeasure8")
    @SerializedName("strMeasure8")
    val strMeasure8: String?,
    @ColumnInfo(name = "strMeasure9")
    @SerializedName("strMeasure9")
    val strMeasure9: String?,
    @ColumnInfo(name = "strMeasure10")
    @SerializedName("strMeasure10")
    val strMeasure10: String?,
    @ColumnInfo(name = "strMeasure11")
    @SerializedName("strMeasure11")
    val strMeasure11: String?,
    @ColumnInfo(name = "strMeasure12")
    @SerializedName("strMeasure12")
    val strMeasure12: String?,
    @ColumnInfo(name = "strMeasure13")
    @SerializedName("strMeasure13")
    val strMeasure13: String?,
    @ColumnInfo(name = "strMeasure14")
    @SerializedName("strMeasure14")
    val strMeasure14: String?,
    @ColumnInfo(name = "strMeasure15")
    @SerializedName("strMeasure15")
    val strMeasure15: String?,



)