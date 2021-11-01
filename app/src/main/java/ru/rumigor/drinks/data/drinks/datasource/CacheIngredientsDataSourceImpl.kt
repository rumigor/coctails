package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.rumigor.drinks.data.InMemory
import ru.rumigor.drinks.data.model.Ingredient
import ru.rumigor.drinks.data.storage.DrinksStorage
import javax.inject.Inject

class CacheIngredientsDataSourceImpl @Inject constructor(
    @InMemory private val drinksStorage: DrinksStorage
): CacheIngredientsDataSource  {
    override fun retainIng(ingredients: List<Ingredient>): Single<List<Ingredient>> =
        drinksStorage
            .drinksDao()
            .retainIng(ingredients)
            .andThen(getIngredientsList().firstOrError())

    override fun retainIng(ingredient: Ingredient): Single<Ingredient> =
        drinksStorage
            .drinksDao()
            .retainIng(ingredient)
            .andThen(Single.just(ingredient))

    override fun filterIngredients(strIngredient: String): Observable<List<Ingredient>> =
        drinksStorage
            .drinksDao()
            .filterIngredients(strIngredient)

    override fun clearCache(): Completable =
        drinksStorage
            .drinksDao()
            .deleteAllIngredients()

    override fun getIngredientsList(): Observable<List<Ingredient>> =
        drinksStorage
            .drinksDao()
            .fetchIngredients()

    override fun deselect(): Completable =
        drinksStorage
            .drinksDao()
            .deselect()
}