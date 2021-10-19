package ru.rumigor.drinks.data.drink

import io.reactivex.Maybe
import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Drink

interface DrinkRepository {
    fun getDrinkByName(idDrink:String): Maybe<Drink>
}