package ru.rumigor.drinks.data.di.modules


import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.rumigor.drinks.data.di.DrinksComponent
import ru.rumigor.drinks.ui.MainActivity

@Module(subcomponents = [DrinksComponent::class])
interface DrinksApplicationModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}