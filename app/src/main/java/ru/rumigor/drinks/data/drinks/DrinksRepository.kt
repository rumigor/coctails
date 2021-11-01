package ru.rumigor.drinks.data.drinks

import io.reactivex.Completable
import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Drink

interface DrinksRepository {
    fun getDrinks(): Observable<List<Drink>>

    fun getDrinkById(drinkID: String): Observable<Drink>

    fun getDrinkByName(drinkName: String): Observable<List<Drink>>

    fun getRandomDrinks(): Observable<List<Drink>>

    fun clearCache(): Completable

    fun getDrinksByIngredients(query:String): Observable<List<Drink>>
}