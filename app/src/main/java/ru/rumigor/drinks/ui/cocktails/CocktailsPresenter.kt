package ru.rumigor.drinks.ui.cocktails


import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.CocktailsViewModel
import ru.rumigor.drinks.ui.DrinksViewModel
import ru.rumigor.drinks.ui.drink.DrinkScreen
import ru.rumigor.drinks.ui.main.MainScreen

class CocktailsPresenter(
    private val drinkName: String,
    private val drinksRepository: DrinksRepository,
    private val router: Router,
    private val schedulers: Schedulers,
    private val query: String
) : MvpPresenter<CocktailsView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
                disposables +=
                drinksRepository
                    .getDrinksByIngredients(query)
                    .observeOn(schedulers.background())
                    .map { drinks -> drinks.map(CocktailsViewModel.Mapper::map) }
                    .observeOn(schedulers.main())
                    .subscribeOn(schedulers.background())
                    .subscribe(
                        viewState::showDrinks,
                        viewState::showError
                    )

        }


    fun displayDrink(drink: CocktailsViewModel) {
        router.navigateTo(DrinkScreen(drink.idDrink))
    }

    override fun onDestroy() {
        disposables.dispose()
    }

    fun onErrorDrink() {
        router.navigateTo(MainScreen)
    }


}