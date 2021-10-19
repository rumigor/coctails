package ru.rumigor.drinks.ui

import ru.rumigor.drinks.data.model.Drink

class DrinksViewModel (
    val idDrink: String,
    val strDrink : String,
    val strDrinkThumb: String,
    val strAlcoholic: String,
    val strInstructions: String
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
            )
    }
}