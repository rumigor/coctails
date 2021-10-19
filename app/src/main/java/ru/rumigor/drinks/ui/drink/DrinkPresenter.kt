package ru.rumigor.drinks.ui.drink

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.DrinksViewModel

class DrinkPresenter(
    private val drinkName: String,
    private val drinksRepository: DrinksRepository,
    private val schedulers: Schedulers,
): MvpPresenter<DrinkView>() {
    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            drinksRepository
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