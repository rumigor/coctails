package ru.rumigor.drinks.data.drinks

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.rumigor.drinks.data.model.Ingredient

interface IngredientsRepository {
    fun getIngredientsList():Observable<List<Ingredient>>
    fun filterIngredients(strIngredient: String): Observable<List<Ingredient>>
    fun updateStatus(strIngredient: String, checked: Boolean): Single<Ingredient>
    fun getIngredientsListFromCache():Observable<List<Ingredient>>
    fun clearCache(): Completable
    fun deselect():Completable
}