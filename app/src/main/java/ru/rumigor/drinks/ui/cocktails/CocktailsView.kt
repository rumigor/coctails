package ru.rumigor.drinks.ui.cocktails


import moxy.viewstate.strategy.alias.SingleState
import ru.rumigor.drinks.ui.CocktailsViewModel
import ru.rumigor.drinks.ui.ScreenView

interface CocktailsView : ScreenView {

    @SingleState
    fun showDrinks(drinks: List<CocktailsViewModel>)

}