package ru.rumigor.drinks.ui.ingredients

import moxy.viewstate.strategy.alias.SingleState
import ru.rumigor.drinks.ui.IngredientsViewModel
import ru.rumigor.drinks.ui.ScreenView

interface IngredientsView: ScreenView {
    @SingleState
    fun loadIngredients(ingredients: List<IngredientsViewModel>)
}