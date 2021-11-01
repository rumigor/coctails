package ru.rumigor.drinks.ui.ingredients

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.rumigor.drinks.data.drinks.IngredientsRepository
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.IngredientsViewModel
import ru.rumigor.drinks.ui.drinks.DrinksScreen


class IngredientsPresenter (
    private val ingredientsRepository: IngredientsRepository,
    private val router: Router,
    private val schedulers: Schedulers
        ): MvpPresenter<IngredientsView>() {
    private val disposables = CompositeDisposable()

    fun showDrinks(query: String) {

        router.navigateTo(DrinksScreen("ingredientSearch", query))
    }

    override fun onDestroy() {
        disposables.clear()
    }

    override fun onFirstViewAttach() {
        disposables +=
            ingredientsRepository
                .getIngredientsList()
                .observeOn(schedulers.background())
                .map{ingredients -> ingredients.map(IngredientsViewModel.Mapper::map)}
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::loadIngredients,
                    viewState::showError
                )
    }

    fun filterIngredients(strIngredient: String) {
        disposables +=
            ingredientsRepository
                .filterIngredients(strIngredient)
                .observeOn(schedulers.background())
                .map { ingredients -> ingredients.map(IngredientsViewModel.Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::loadIngredients,
                    viewState::showError
                )
    }

    fun loadAllIngredients(){
        disposables +=
            ingredientsRepository
                .getIngredientsListFromCache()
                .observeOn(schedulers.background())
                .map{ingredients -> ingredients.map(IngredientsViewModel.Mapper::map)}
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::loadIngredients,
                    viewState::showError
                )
    }

    fun updateStatus(strIngredient: String, checked: Boolean){
        disposables +=
            ingredientsRepository
                .updateStatus(strIngredient, checked)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe()
    }

    fun deselect() {
        disposables +=
            ingredientsRepository
                .deselect()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe()
    }
}