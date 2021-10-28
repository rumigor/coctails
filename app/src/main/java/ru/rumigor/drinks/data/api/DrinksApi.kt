package ru.rumigor.drinks.data.api


import io.reactivex.Single
import retrofit2.http.GET
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.model.Drinks


interface DrinksApi {

    @GET("drinks")
    fun getDrinks(): Single<Drinks>



}