package ru.rumigor.drinks.data.drink

import io.reactivex.Maybe
import ru.rumigor.drinks.data.drink.datasource.CacheDrinkDataSource
import ru.rumigor.drinks.data.model.Drink
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val cache: CacheDrinkDataSource
) : DrinkRepository {
    override fun getDrinkByName(idDrink: String): Maybe<Drink> =
        cache.getDrinkByName(idDrink)
}