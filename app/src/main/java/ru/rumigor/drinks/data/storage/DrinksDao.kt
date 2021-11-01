package ru.rumigor.drinks.data.storage

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.model.Ingredient

@Dao
interface DrinksDao {
    @Query("SELECT * FROM drinks")
    fun fetchDrinks(): Observable<List<Drink>>

    @Query("SELECT * FROM drinks WHERE idDrink LIKE :idDrink LIMIT 1")
    fun fetchDrinksById(idDrink: String): Single<Drink>

    @Query("SELECT * FROM drinks WHERE drinkCategory LIKE :drinkCategory")
    fun fetchDrinksByCategory(drinkCategory: String): Observable<List<Drink>>

    @Query("SELECT * FROM ingredients")
    fun fetchIngredients(): Observable<List<Ingredient>>

    @Query("SELECT * FROM ingredients WHERE strIngredient1 LIKE '%'|| :strIngredient || '%'")
    fun filterIngredients(strIngredient: String): Observable<List<Ingredient>>

    @Query("SELECT * FROM ingredients WHERE strIngredient1 LIKE :strIngredient")
    fun getStatus(strIngredient: String): Single<Ingredient>

    @Insert(onConflict = REPLACE)
    fun retainIng(ingredients: List<Ingredient>): Completable

    @Update(onConflict = REPLACE)
    fun retainIng(ingredient: Ingredient): Completable


    @Query("UPDATE ingredients SET checked = 0")
    fun deselect():Completable

    @Query("DELETE FROM drinks")
    fun deleteAll(): Completable

    @Query("DELETE FROM ingredients")
    fun deleteAllIngredients(): Completable


    @Insert(onConflict = REPLACE)
    fun retain(drinks: List<Drink>): Completable

    @Update(onConflict = REPLACE)
    fun retain(drink: Drink): Completable

}