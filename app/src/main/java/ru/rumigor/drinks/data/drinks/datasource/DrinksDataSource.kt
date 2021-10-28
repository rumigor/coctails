package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Drink

interface DrinksDataSource {

    fun getDrinks(): Observable<List<Drink>>

}