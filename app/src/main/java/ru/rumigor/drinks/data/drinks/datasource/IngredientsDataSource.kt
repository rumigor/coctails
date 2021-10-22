package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Ingredient

interface IngredientsDataSource {
    fun getIngredientsList(): Observable<List<Ingredient>>
}