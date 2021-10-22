package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Drink

interface DrinksDataSource {

    fun getDrinks(): Observable<List<Drink>>
    fun getDrinkByName(drinkName: String): Observable<List<Drink>>
    fun getRandomDrinks(): Observable<List<Drink>>
    fun getDrinksByIngredients(query: String): Observable<List<Drink>>

}