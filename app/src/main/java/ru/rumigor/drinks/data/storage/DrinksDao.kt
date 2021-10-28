package ru.rumigor.drinks.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.rumigor.drinks.data.model.Drink

@Dao
interface DrinksDao {
    @Query("SELECT * FROM drinks")
    fun fetchDrinks(): Observable<List<Drink>>

    @Query("SELECT * FROM drinks WHERE strDrink LIKE :strDrink LIMIT 1")
    fun fetchDrinksByName(strDrink: String): Single<Drink>

    @Insert(onConflict = REPLACE)
    fun retain(drinks: List<Drink>): Completable
    @Update(onConflict = REPLACE)
    fun retain(drink: Drink): Completable
}