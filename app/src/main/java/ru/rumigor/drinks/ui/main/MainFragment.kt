package ru.rumigor.drinks.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter
import ru.rumigor.drinks.R
import ru.rumigor.drinks.arguments
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.data.drinks.IngredientsRepository
import ru.rumigor.drinks.ui.abs.AbsFragment
import ru.rumigor.drinks.databinding.ViewMainFragmentBinding
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.IngredientsViewModel
import javax.inject.Inject

class MainFragment : AbsFragment(R.layout.view_main_fragment), MainView {
    companion object {

        fun newInstance(): Fragment =
            MainFragment()
                .arguments()

    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var drinksRepository: DrinksRepository

    @Inject
    lateinit var ingredientsRepository: IngredientsRepository


    @Suppress("unused")
    private val presenter: MainPresenter by moxyPresenter {
        MainPresenter(
            router = router,
            schedulers = schedulers,
            drinksRepository = drinksRepository,
        )
    }

    private val viewBiding: ViewMainFragmentBinding by viewBinding()

    private var ingredientsList = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBiding.loadIngredients.setOnClickListener {
            presenter.displayIngredients()
        }

        viewBiding.topCocktails.setOnClickListener {
            presenter.displayTopDrinks()
        }

        viewBiding.randomDrinks.setOnClickListener {
            presenter.displayRandomDrinks()
        }

        viewBiding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { presenter.displayDrinkByName(query) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }


    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
        Log.d("ERROR", error.message.toString())
    }
}