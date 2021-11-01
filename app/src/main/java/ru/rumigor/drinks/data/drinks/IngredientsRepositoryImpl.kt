package ru.rumigor.drinks.data.drinks

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
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

    override fun filterIngredients(strIngredient: String): Observable<List<Ingredient>> =
        cache.filterIngredients(strIngredient)

    override fun updateStatus(strIngredient: String, checked: Boolean): Single<Ingredient>{
        val ingredient = Ingredient(strIngredient, checked)
        return cache.retainIng(ingredient)
    }

    override fun getIngredientsListFromCache(): Observable<List<Ingredient>> = cache.getIngredientsList()

    override fun clearCache(): Completable =
        cache.clearCache()

    override fun deselect(): Completable =
        cache.deselect()
}