package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.rumigor.drinks.data.model.Ingredient

interface CacheIngredientsDataSource: IngredientsDataSource {
    fun retainIng(ingredients: List<Ingredient>): Single<List<Ingredient>>
    fun retainIng(ingredient: Ingredient): Single<Ingredient>
    fun filterIngredients(strIngredient: String): Observable<List<Ingredient>>
    fun clearCache(): Completable
    fun deselect(): Completable
}