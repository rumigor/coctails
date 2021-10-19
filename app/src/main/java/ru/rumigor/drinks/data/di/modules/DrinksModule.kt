package ru.rumigor.drinks.data.di.modules


import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.data.drinks.DrinksRepositoryImpl
import ru.rumigor.drinks.data.drinks.datasource.CacheDrinksDataSource
import ru.rumigor.drinks.data.drinks.datasource.CacheDrinksDataSourceImpl
import ru.rumigor.drinks.data.drinks.datasource.CloudDrinksDataSource
import ru.rumigor.drinks.data.drinks.datasource.DrinksDataSource
import ru.rumigor.drinks.ui.MainActivity
import ru.rumigor.drinks.ui.drink.DrinkFragment
import ru.rumigor.drinks.ui.drinks.DrinksFragment

@Module
interface DrinksModule{

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector
    fun bindDrinksFragment(): DrinksFragment
    @ContributesAndroidInjector
    fun bindDrinkFragment(): DrinkFragment

    @Binds
    fun bindDrinksRepository(repository: DrinksRepositoryImpl): DrinksRepository
    @Binds
    fun bindDrinksDataSource(dataSource: CloudDrinksDataSource): DrinksDataSource
    @Binds
    fun bindCacheDrinksDataSource(dataSourceImpl: CacheDrinksDataSourceImpl): CacheDrinksDataSource
}