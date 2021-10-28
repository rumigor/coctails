package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Single
import ru.rumigor.drinks.data.model.Drink

interface CacheDrinksDataSource : DrinksDataSource {

    fun retain(drinks: List<Drink>): Single<List<Drink>>

}