package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Maybe
import io.reactivex.Observable
import ru.rumigor.drinks.data.InMemory
import ru.rumigor.drinks.data.api.DrinksApi
import ru.rumigor.drinks.data.model.Cocktail
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

    override fun getDrinksByIngredients(query: String): Observable<List<Cocktail>> =
        drinksApi
            .getDrinksByIngredients(query)
            .toObservable()
            .map{
                it.drinks
            }

    override fun getDrinkById(idDrink: String): Observable<Drink> =
        drinksApi
            .getDrinkByID(idDrink)
            .toObservable()
            .map {
                it.drinks[0]
            }
}