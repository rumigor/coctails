package ru.rumigor.drinks.data.drinks

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import ru.rumigor.drinks.data.drinks.datasource.CacheDrinksDataSource
import ru.rumigor.drinks.data.drinks.datasource.DrinksDataSource
import ru.rumigor.drinks.data.model.Drink
import javax.inject.Inject

class DrinksRepositoryImpl @Inject constructor(
    private val cloud: DrinksDataSource,
    private val cache: CacheDrinksDataSource
) : DrinksRepository {
    override fun getDrinks(): Observable<List<Drink>> =
        Observable.merge(
            cache.getDrinks(),
            cloud.getDrinks().flatMapSingle(cache::retain)
        )

    override fun getDrinkById(drinkID: String): Maybe<Drink> =
        cache.getDrinkById(drinkID)

    override fun getDrinkByName(drinkName: String): Observable<List<Drink>> =
        Observable.merge(
            cache.getDrinkByName(drinkName),
            cloud.getDrinkByName(drinkName).flatMapSingle(cache::retain)
        )

    override fun getRandomDrinks(): Observable<List<Drink>> =
        Observable.merge(
            cache.getRandomDrinks(),
            cloud.getRandomDrinks().flatMapSingle(cache::retain)
        )

    override fun clearCache(): Completable =
        cache.clearCache()
}