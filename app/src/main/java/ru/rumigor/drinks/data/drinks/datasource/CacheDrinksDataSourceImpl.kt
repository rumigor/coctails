package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import io.reactivex.Single
import ru.rumigor.drinks.data.InMemory
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.storage.DrinksStorage
import javax.inject.Inject

class CacheDrinksDataSourceImpl @Inject constructor(
    @InMemory private val drinksStorage: DrinksStorage
) : CacheDrinksDataSource {

    override fun getDrinks(): Observable<List<Drink>> =
        drinksStorage
            .driksDao()
            .fetchDrinks()

    override fun retain(drinks: List<Drink>): Single<List<Drink>> =
        drinksStorage
            .driksDao()
            .retain(drinks)
            .andThen(getDrinks().firstOrError())

}