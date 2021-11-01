package ru.rumigor.drinks.ui.main

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.drinks.DrinksScreen
import ru.rumigor.drinks.ui.ingredients.IngredientsScreen

class MainPresenter(
    private val router: Router,
    private val drinksRepository: DrinksRepository,
    private val schedulers: Schedulers,
) : MvpPresenter<MainView>() {
    fun displayTopDrinks() {
        clearCache()
        router.navigateTo(DrinksScreen("popular", ""))
    }

    fun displayRandomDrinks() {
        clearCache()
        router.navigateTo(DrinksScreen("random", ""))
    }

    fun displayDrinkByName(drinkName: String) {
        clearCache()
        router.navigateTo(DrinksScreen(drinkName, ""))
    }

    fun displayIngredients(){
        router.navigateTo(IngredientsScreen())
    }

    private val disposables = CompositeDisposable()

    private fun clearCache() {
        disposables +=
            drinksRepository
                .clearCache()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe()
    }


}