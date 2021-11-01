package ru.rumigor.drinks.ui

import ru.rumigor.drinks.data.model.Cocktail

class CocktailsViewModel
    (
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String
) {
    object Mapper {
        fun map(cocktail: Cocktail) =
            CocktailsViewModel(
                cocktail.idDrink,
                cocktail.strDrink.toUpperCase(),
                cocktail.strDrinkThumb
            )
    }
}