package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Completable
import io.reactivex.Maybe
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
            .drinksDao()
            .fetchDrinks()

    override fun getDrinkByName(drinkName: String): Observable<List<Drink>> =
        drinksStorage
            .drinksDao()
            .fetchDrinks()

    override fun getRandomDrinks(): Observable<List<Drink>> =
        getDrinks()

    override fun retain(drinks: List<Drink>): Single<List<Drink>> =
        drinksStorage
            .drinksDao()
            .retain(drinks)
            .andThen(getDrinks().firstOrError())

    override fun retain(drink: Drink): Single<Drink> =
        drinksStorage
            .drinksDao()
            .retain(drink)
            .andThen(Single.just(drink))

    override fun getDrinkById(idDrink: String): Maybe<Drink> = drinksStorage
            .drinksDao()
            .fetchDrinksById(idDrink)
            .toMaybe()

    override fun clearCache(): Completable =
            drinksStorage
                .drinksDao()
                .deleteAll()
}