package ru.rumigor.drinks.data.di.modules


import dagger.Binds
import dagger.Module

import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.data.drinks.DrinksRepositoryImpl
import ru.rumigor.drinks.data.drinks.datasource.CacheDrinksDataSource
import ru.rumigor.drinks.data.drinks.datasource.CacheDrinksDataSourceImpl
import ru.rumigor.drinks.data.drinks.datasource.CloudDrinksDataSource
import ru.rumigor.drinks.data.drinks.datasource.DrinksDataSource

@Module(includes = [DrinksStorageModule::class, DrinksApiModule::class])
interface DrinksRepositoryModule {

    @Binds
    fun bindDrinksRepository(repository: DrinksRepositoryImpl): DrinksRepository
    @Binds
    fun bindDrinksDataSource(dataSource: CloudDrinksDataSource): DrinksDataSource
    @Binds
    fun bindCacheDrinksDataSource(dataSourceImpl: CacheDrinksDataSourceImpl): CacheDrinksDataSource

}