package ru.rumigor.drinks.data.drinks

import io.reactivex.Observable
import ru.rumigor.drinks.data.model.Ingredient

interface IngredientsRepository {
    fun getIngredientsList():Observable<List<Ingredient>>
}