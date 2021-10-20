package ru.rumigor.drinks.ui

import ru.rumigor.drinks.data.model.Drink

class DrinksViewModel (
    val idDrink: String,
    val strDrink : String,
    val strDrinkThumb: String,
    val strAlcoholic: String,
    val strInstructions: String,
//    val strIngredient1: String,
//    val strIngredient2: String,
//    val strIngredient3: String,
//    val strIngredient4: String,
//    val strIngredient5: String,
//    val strIngredient6: String,
//    val strIngredient7: String,
//    val strIngredient8: String,
//    val strIngredient9: String,
//    val strIngredient10: String,
//    val strIngredient11: String,
//    val strIngredient12: String,
//    val strIngredient13: String,
//    val strIngredient14: String,
//    val strIngredient15: String


)
{
    object Mapper{
        fun map(drink: Drink) =
            DrinksViewModel(
                drink.idDrink,
                drink.strDrink.toUpperCase(),
                drink.strDrinkThumb,
                drink.strAlcoholic,
                drink.strInstructions,
//                drink.strIngredient1,
//                drink.strIngredient2,
//                drink.strIngredient3,
//                drink.strIngredient4,
//                drink.strIngredient5,
//                drink.strIngredient6,
//                drink.strIngredient7,
//                drink.strIngredient8,
//                drink.strIngredient9,
//                drink.strIngredient10,
//                drink.strIngredient11,
//                drink.strIngredient12,
//                drink.strIngredient13,
//                drink.strIngredient14,
//                drink.strIngredient15
            )
    }
}