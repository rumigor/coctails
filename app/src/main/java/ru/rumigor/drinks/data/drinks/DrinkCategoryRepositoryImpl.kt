package ru.rumigor.drinks.data.drinks

import io.reactivex.Observable
import ru.rumigor.drinks.data.drinks.datasource.DrinkCategorySource
import ru.rumigor.drinks.data.model.DrinkCategory
import javax.inject.Inject

class DrinkCategoryRepositoryImpl @Inject constructor(
    private val cloud: DrinkCategorySource
): DrinkCategoryRepository {
    override fun getCategoryList(): Observable<List<DrinkCategory>> =
        cloud.getDrinkCategoryList()
}