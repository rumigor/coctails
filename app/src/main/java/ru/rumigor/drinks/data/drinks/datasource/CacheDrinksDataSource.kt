package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import ru.rumigor.drinks.data.model.Drink

interface CacheDrinksDataSource : DrinksDataSource {

    fun retain(drinks: List<Drink>): Single<List<Drink>>
    fun retain(drink: Drink): Single<Drink>
    fun getDrinkById (idDrink:String): Maybe<Drink>
    fun clearCache(): Completable
}