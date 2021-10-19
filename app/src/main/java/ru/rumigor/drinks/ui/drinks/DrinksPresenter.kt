package ru.rumigor.drinks.ui.drinks


import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.DrinksViewModel

class DrinksPresenter(
    private val drinksRepository: DrinksRepository,
    private val router: Router,
    private val schedulers: Schedulers
): MvpPresenter<DrinksView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
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
    }

//    fun displayUser(drinks: DrinksViewModel) {
//        router.navigateTo(UserScreen(user.login))
//    }

    override fun onDestroy() {
        disposables.dispose()
    }

}