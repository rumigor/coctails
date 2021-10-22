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

    @Query("SELECT * FROM ingredients")
    fun fetchIngredients(): Observable<List<Ingredient>>

    @Insert(onConflict = REPLACE)
    fun retainIng(ingredients: List<Ingredient>):Completable
    @Update(onConflict = REPLACE)
    fun retainIng(ingredient: Ingredient): Completable

    @Query("DELETE FROM drinks")
    fun deleteAll(): Completable


    @Insert(onConflict = REPLACE)
    fun retain(drinks: List<Drink>): Completable
    @Update(onConflict = REPLACE)
    fun retain(drink: Drink): Completable

}