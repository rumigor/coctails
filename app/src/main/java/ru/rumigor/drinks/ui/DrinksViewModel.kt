package ru.rumigor.drinks.ui

import ru.rumigor.drinks.data.model.Drink

class DrinksViewModel (
    val strDrink : String,
    val strDrinkThumb: String
)
{
    object Mapper{
        fun map(drink: Drink) =
            DrinksViewModel(
                drink.strDrink.toUpperCase(),
                drink.strDrinkThumb
            )
    }
}