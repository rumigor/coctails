package ru.rumigor.drinks.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.rumigor.drinks.data.model.Drink
import ru.rumigor.drinks.data.model.Ingredient

@Database(exportSchema = false, entities = [Drink::class, Ingredient::class], version = 1)
abstract class DrinksStorage: RoomDatabase() {
    abstract fun drinksDao(): DrinksDao
}