package ru.rumigor.drinks.data.api


import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.model.Drinks


interface DrinksApi {

    @GET("/popular.php")
    fun getDrinks(): Single<Drinks>

    @GET("/search.php")
    fun getDrinkByName(@Query("s")drinkName:String): Single<Drinks>

    @GET("/randomselection.php")
    fun getRandomDrinks(): Single<Drinks>



}