package ru.rumigor.drinks.ui.main

import ru.rumigor.drinks.data.model.DrinkCategory

class DrinkCategoryViewModel(
    val strCategory: String
) {
    object Mapper {
        fun map(drinkCategory: DrinkCategory) =
            DrinkCategoryViewModel(drinkCategory.strCategory)
    }
}