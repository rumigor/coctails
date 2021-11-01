package ru.rumigor.drinks.ui

import ru.rumigor.drinks.data.model.Ingredient

class IngredientsViewModel(
    val strIngredient1: String,
    var checked: Boolean
) {
    object Mapper {
        fun map(ingredient: Ingredient) =
            IngredientsViewModel(
                ingredient.strIngredient1,
                ingredient.checked
            )
    }
}