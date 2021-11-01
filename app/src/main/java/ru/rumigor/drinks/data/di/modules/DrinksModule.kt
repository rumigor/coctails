package ru.rumigor.drinks.data.di.modules


import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.data.drinks.DrinksRepositoryImpl
import ru.rumigor.drinks.data.drinks.IngredientsRepository
import ru.rumigor.drinks.data.drinks.IngredientsRepositoryImpl
import ru.rumigor.drinks.data.drinks.datasource.*
import ru.rumigor.drinks.ui.MainActivity
import ru.rumigor.drinks.ui.drink.DrinkFragment
import ru.rumigor.drinks.ui.cocktails.CocktailFragment
import ru.rumigor.drinks.ui.drinks.DrinksFragment
import ru.rumigor.drinks.ui.ingredients.IngredientsFragment
import ru.rumigor.drinks.ui.main.MainFragment
import javax.inject.Singleton

@Module
interface DrinksModule{

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector
    fun bindDrinksFragment(): DrinksFragment
    @ContributesAndroidInjector
    fun bindDrinkFragment(): DrinkFragment
    @ContributesAndroidInjector
    fun bindMainFragment(): MainFragment
    @ContributesAndroidInjector
    fun bindIngredientsFragment(): IngredientsFragment
    @ContributesAndroidInjector
    fun bindCocktailsFragment(): CocktailFragment

    @Singleton
    @Binds
    fun bindDrinksRepository(repository: DrinksRepositoryImpl): DrinksRepository
    @Singleton
    @Binds
    fun bindIngredientsRepository(ingredientsRepository: IngredientsRepositoryImpl): IngredientsRepository

    @Singleton
    @Binds
    fun bindIngredientsDataSource(ingredientsDataSource: CloudIngredientsSource): IngredientsDataSource

    @Singleton
    @Binds
    fun bindCacheIngredientsDataSource(ingredientsDataSourceImpl: CacheIngredientsDataSourceImpl): CacheIngredientsDataSource

    @Singleton
    @Binds
    fun bindDrinksDataSource(dataSource: CloudDrinksDataSource): DrinksDataSource
    @Singleton
    @Binds
    fun bindCacheDrinksDataSource(dataSourceImpl: CacheDrinksDataSourceImpl): CacheDrinksDataSource
}