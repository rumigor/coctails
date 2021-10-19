package ru.rumigor.drinks.data.di.modules

import dagger.Module

@Module(includes = [DrinkRepositoryModule::class])
interface DrinkModule {
}