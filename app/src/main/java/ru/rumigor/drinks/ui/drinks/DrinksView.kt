package ru.rumigor.drinks.ui.drinks



import moxy.viewstate.strategy.alias.SingleState
import ru.rumigor.drinks.ui.DrinksViewModel
import ru.rumigor.drinks.ui.ScreenView

interface DrinksView : ScreenView {

    @SingleState
    fun showDrinks(drinks: List<DrinksViewModel>)

}