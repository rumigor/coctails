package ru.rumigor.drinks.data.drinks

import io.reactivex.Observable
import ru.rumigor.drinks.data.drinks.datasource.CacheIngredientsDataSource
import ru.rumigor.drinks.data.drinks.datasource.IngredientsDataSource
import ru.rumigor.drinks.data.model.Ingredient
import javax.inject.Inject

class IngredientsRepositoryImpl @Inject constructor(
    private val cloud: IngredientsDataSource,
    private val cache: CacheIngredientsDataSource
) : IngredientsRepository {
    override fun getIngredientsList(): Observable<List<Ingredient>> =
        Observable.merge(
            cache.getIngredientsList(),
            cloud.getIngredientsList().flatMapSingle(cache::retainIng)
        )
}