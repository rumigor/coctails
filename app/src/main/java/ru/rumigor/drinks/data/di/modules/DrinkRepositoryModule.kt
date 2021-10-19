package ru.rumigor.drinks.data.di.modules

import dagger.Binds
import dagger.Module
import ru.rumigor.drinks.data.drink.DrinkRepository
import ru.rumigor.drinks.data.drink.DrinkRepositoryImpl
import ru.rumigor.drinks.data.drink.datasource.CacheDrinkDataSource
import ru.rumigor.drinks.data.drink.datasource.CacheDrinkDataSourceImpl

@Module(includes = [DrinksStorageModule::class])
interface DrinkRepositoryModule {
    @Binds
    fun bindDrinkRepository(repository: DrinkRepositoryImpl): DrinkRepository
    @Binds
    fun bindCacheDrinkDataSource(dataSource: CacheDrinkDataSourceImpl): CacheDrinkDataSource
}