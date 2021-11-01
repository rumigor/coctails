package ru.rumigor.drinks.data.drinks

import io.reactivex.Observable
import ru.rumigor.drinks.data.model.DrinkCategory

interface DrinkCategoryRepository {
    fun getCategoryList(): Observable<List<DrinkCategory>>
}