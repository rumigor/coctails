package ru.rumigor.drinks.data.drink.datasource

import io.reactivex.Single
import ru.rumigor.drinks.data.model.Drink

interface CacheDrinkDataSource: DrinkDataSource {
    fun retain(drink: Drink): Single<Drink>
}