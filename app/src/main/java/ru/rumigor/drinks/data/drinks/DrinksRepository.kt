package ru.rumigor.drinks.data.drinks

import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.model.Drinks

interface DrinksRepository {
    fun getDrinks(): Observable<List<Drink>>
}