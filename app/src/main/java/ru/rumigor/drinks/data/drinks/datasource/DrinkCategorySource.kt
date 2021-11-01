package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import ru.rumigor.drinks.data.model.DrinkCategory


interface DrinkCategorySource {
    fun getDrinkCategoryList(): Observable<List<DrinkCategory>>
}