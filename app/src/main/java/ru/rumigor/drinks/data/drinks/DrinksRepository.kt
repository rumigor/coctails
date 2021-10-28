package ru.rumigor.drinks.data.drinks

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.model.Drinks

interface DrinksRepository {
    fun getDrinks(): Observable<List<Drink>>

    fun getDrinkById(drinkID: String): Maybe<Drink>

    fun getDrinkByName(drinkName: String): Observable<List<Drink>>

    fun getRandomDrinks(): Observable<List<Drink>>

    fun clearCache(): Completable
}