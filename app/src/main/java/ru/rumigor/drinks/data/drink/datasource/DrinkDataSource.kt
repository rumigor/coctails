package ru.rumigor.drinks.data.drink.datasource

import io.reactivex.Maybe
import ru.rumigor.drinks.data.model.Drink

interface DrinkDataSource {
    fun getDrinkByName (idDrink:String): Maybe<Drink>
}