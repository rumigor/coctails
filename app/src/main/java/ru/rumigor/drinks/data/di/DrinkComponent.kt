package ru.rumigor.drinks.data.di

import dagger.Subcomponent
import ru.rumigor.drinks.data.di.modules.DrinkModule
import ru.rumigor.drinks.ui.drink.DrinkFragment

@Drink
@Subcomponent(modules = [DrinkModule::class])
interface DrinkComponent {
    fun inject(drinkFragment: DrinkFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): DrinkComponent

    }
}