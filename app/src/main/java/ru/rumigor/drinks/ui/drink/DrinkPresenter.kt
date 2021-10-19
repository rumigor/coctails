package ru.rumigor.drinks.ui.drink

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.rumigor.drinks.data.drink.DrinkRepository
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.DrinksViewModel

class DrinkPresenter(
    private val drinkName: String,
    private val drinkRepository: DrinkRepository,
    private val schedulers: Schedulers,
    private val router: Router
): MvpPresenter<DrinkView>() {
    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            drinkRepository
                .getDrinkByName(drinkName)
                .map(DrinksViewModel.Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showDrink,
                    viewState::showError
                )
    }

    override fun onDestroy() {
        disposables.clear()
    }

}