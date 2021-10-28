package ru.rumigor.drinks.ui.drink

import moxy.viewstate.strategy.alias.SingleState
import ru.rumigor.drinks.ui.DrinksViewModel
import ru.rumigor.drinks.ui.ScreenView

interface DrinkView: ScreenView {
    @SingleState
    fun showDrink(drink: DrinksViewModel)

}