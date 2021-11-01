package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import ru.rumigor.drinks.data.api.DrinksApi
import ru.rumigor.drinks.data.model.DrinkCategory
import javax.inject.Inject

class CloudDrinkCategorySource@Inject constructor(
    private val drinksApi: DrinksApi): DrinkCategorySource {
    override fun getDrinkCategoryList(): Observable<List<DrinkCategory>> =
        drinksApi
            .getCategoryList("list")
            .toObservable()
            .map { it.drinkCategories }
}