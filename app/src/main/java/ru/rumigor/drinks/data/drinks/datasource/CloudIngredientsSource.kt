package ru.rumigor.drinks.data.drinks.datasource

import io.reactivex.Observable
import ru.rumigor.drinks.data.InMemory
import ru.rumigor.drinks.data.api.DrinksApi
import ru.rumigor.drinks.data.model.Ingredient
import ru.rumigor.drinks.data.model.Ingredients
import ru.rumigor.drinks.data.storage.DrinksStorage
import javax.inject.Inject

class CloudIngredientsSource @Inject constructor(
    private val drinksApi: DrinksApi,
    @InMemory private val drinksStorage: DrinksStorage
) : IngredientsDataSource {
    override fun getIngredientsList(): Observable<List<Ingredient>> =
        drinksApi
            .getIngredientsList("list")
            .toObservable()
            .map {
                it.ingredients
            }
}