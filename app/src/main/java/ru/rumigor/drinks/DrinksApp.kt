package ru.rumigor.drinks

import android.util.Log
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins
import ru.rumigor.drinks.data.di.DaggerDrinksApplicationComponent
import ru.rumigor.drinks.data.di.DrinksApplicationComponent
import ru.rumigor.drinks.scheduler.DefaultSchedulers

class DrinksApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<DrinksApp> = drinksApplicationComponent

    private val drinksApplicationComponent: DrinksApplicationComponent by lazy {
        DaggerDrinksApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(DefaultSchedulers())
            }
            .build()
    }
}