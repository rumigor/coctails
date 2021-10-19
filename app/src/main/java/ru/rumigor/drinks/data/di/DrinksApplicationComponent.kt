package ru.rumigor.drinks.data.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.rumigor.drinks.DrinksApp
import ru.rumigor.drinks.data.di.modules.*
import ru.rumigor.drinks.scheduler.Schedulers
import javax.inject.Singleton


@Singleton
@Component(
    modules = [AndroidInjectionModule::class,  DrinksApiModule::class,
    DrinksModule::class, DrinksStorageModule::class]
)
interface DrinksApplicationComponent: AndroidInjector<DrinksApp> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): DrinksApplicationComponent
    }
}