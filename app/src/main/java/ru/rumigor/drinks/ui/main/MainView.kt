package ru.rumigor.drinks.ui.main

import moxy.viewstate.strategy.alias.SingleState
import ru.rumigor.drinks.ui.ScreenView

interface MainView : ScreenView {

    @SingleState
    fun showCategories (drinkCategories: List<DrinkCategoryViewModel>)

}