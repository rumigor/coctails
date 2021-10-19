package ru.rumigor.drinks.data.drinks

import io.reactivex.Maybe
import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.model.Drinks

interface DrinksRepository {
    fun getDrinks(): Observable<List<Drink>>

    fun getDrinkByName(drinkID: String): Maybe<Drink>
}