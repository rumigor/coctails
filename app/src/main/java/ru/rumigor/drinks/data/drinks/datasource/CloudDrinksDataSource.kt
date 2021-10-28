package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import ru.rumigor.drinks.data.api.DrinksApi
import ru.rumigor.drinks.data.model.Drink
import javax.inject.Inject

class CloudDrinksDataSource @Inject constructor(
    private val drinksApi: DrinksApi
) : DrinksDataSource {

    override fun getDrinks(): Observable<List<Drink>> =
        drinksApi
            .getDrinks()
            .toObservable()
            .map{
                it.drinks
            }

}