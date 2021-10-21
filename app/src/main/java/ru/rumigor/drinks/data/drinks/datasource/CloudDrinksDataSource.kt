package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import ru.rumigor.drinks.data.InMemory
import ru.rumigor.drinks.data.api.DrinksApi
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.storage.DrinksStorage
import javax.inject.Inject

class CloudDrinksDataSource @Inject constructor(
    private val drinksApi: DrinksApi,
    @InMemory private val drinksStorage: DrinksStorage
) : DrinksDataSource {

    override fun getDrinks(): Observable<List<Drink>> =
        drinksApi
            .getDrinks()
            .toObservable()
            .map{
                it.drinks
            }

    override fun getDrinkByName(drinkName: String): Observable<List<Drink>> =
        drinksApi
            .getDrinkByName(drinkName)
            .toObservable()
            .map{
                it.drinks
            }

        override fun getRandomDrinks(): Observable<List<Drink>> =
        drinksApi
            .getRandomDrinks()
            .toObservable()
            .map{
                it.drinks
            }

}