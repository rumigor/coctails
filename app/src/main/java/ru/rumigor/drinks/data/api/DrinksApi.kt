package ru.rumigor.drinks.data.api


import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.rumigor.drinks.data.model.Cocktails
import ru.rumigor.drinks.data.model.Drinks
import ru.rumigor.drinks.data.model.Ingredients


interface DrinksApi {

    @GET("/popular.php")
    fun getDrinks(): Single<Drinks>

    @GET("/search.php")
    fun getDrinkByName(@Query("s")drinkName:String): Single<Drinks>

    @GET("/randomselection.php")
    fun getRandomDrinks(): Single<Drinks>

    @GET("/list.php")
    fun getIngredientsList(@Query("i")index:String): Single<Ingredients>

    @GET ("/filter.php")
    fun getDrinksByIngredients(@Query("i")query:String): Single<Cocktails>

    @GET ("/lookup.php")
    fun getDrinkByID(@Query("i")drinkID: String): Single<Drinks>


}