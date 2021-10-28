package ru.rumigor.drinks.data.di

import ru.rumigor.drinks.data.di.modules.DrinksModule
import dagger.Subcomponent
import ru.rumigor.drinks.ui.drinks.DrinksFragment


@Drinks
@Subcomponent(modules = [DrinksModule::class])
interface DrinksComponent {

    fun inject(drinksFragment: DrinksFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): DrinksComponent

    }
}
