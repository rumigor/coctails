package ru.rumigor.drinks.ui.drinks


import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.DrinksViewModel
import ru.rumigor.drinks.ui.drink.DrinkScreen
import ru.rumigor.drinks.ui.main.MainScreen

class DrinksPresenter(
    private val drinkName: String,
    private val drinksRepository: DrinksRepository,
    private val router: Router,
    private val schedulers: Schedulers,
) : MvpPresenter<DrinksView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() =

        when (drinkName) {
            "popular" -> disposables +=
                drinksRepository
                    .getDrinks()
                    .observeOn(schedulers.background())
                    .map { drinks -> drinks.map(DrinksViewModel.Mapper::map) }
                    .observeOn(schedulers.main())
                    .subscribeOn(schedulers.background())
                    .subscribe(
                        viewState::showDrinks,
                        viewState::showError
                    )
            "random" -> disposables +=
                drinksRepository
                    .getRandomDrinks()
                    .observeOn(schedulers.background())
                    .map { drinks -> drinks.map(DrinksViewModel.Mapper::map) }
                    .observeOn(schedulers.main())
                    .subscribeOn(schedulers.background())
                    .subscribe(
                        viewState::showDrinks,
                        viewState::showError
                    )
            else -> disposables +=
                drinksRepository
                    .getDrinkByName(drinkName)
                    .observeOn(schedulers.background())
                    .map { drinks -> drinks.map(DrinksViewModel.Mapper::map) }
                    .observeOn(schedulers.main())
                    .subscribeOn(schedulers.background())
                    .subscribe(
                        viewState::showDrinks,
                        viewState::showError
                    )
        }


    fun displayDrink(drink: DrinksViewModel) {
        router.navigateTo(DrinkScreen(drink.idDrink))
    }

    override fun onDestroy() {
        disposables.dispose()
    }

    fun onErrorDrink() {
        router.navigateTo(MainScreen)
    }


}