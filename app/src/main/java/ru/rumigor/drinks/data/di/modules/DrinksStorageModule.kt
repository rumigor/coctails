package ru.rumigor.drinks.data.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.rumigor.drinks.data.InMemory
import ru.rumigor.drinks.data.Persisted
import ru.rumigor.drinks.data.storage.DrinksStorage

@Module
class DrinksStorageModule {

    @Persisted
    @Provides
    fun provideDrinksDatabaseStorage(context: Context): DrinksStorage =
        Room.databaseBuilder(context, DrinksStorage::class.java, "drinks.db")
            .build()

    @InMemory
    @Provides
    fun provideDrinksInMemoryDatabaseStorage(context: Context): DrinksStorage =
        Room.inMemoryDatabaseBuilder(context, DrinksStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()

}