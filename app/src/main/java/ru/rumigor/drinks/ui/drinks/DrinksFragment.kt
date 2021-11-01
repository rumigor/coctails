package ru.rumigor.drinks.ui.drinks


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import moxy.ktx.moxyPresenter

import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import ru.rumigor.drinks.R
import ru.rumigor.drinks.arguments
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.databinding.ViewDrinksBinding
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.DrinksViewModel
import ru.rumigor.drinks.ui.abs.AbsFragment
import ru.rumigor.drinks.ui.drinks.adapter.DrinksAdapter
import javax.inject.Inject

class DrinksFragment : AbsFragment(R.layout.view_drinks), DrinksView, DrinksAdapter.Delegate {

    companion object {

        private const val ARG_DRINK_NAME = "arg_drink_name"
        private const val ARG_DRINK_QUERY = "arg_drink_query"

        fun newInstance(drinkName: String, query: String): Fragment =
            DrinksFragment()
                .arguments(ARG_DRINK_NAME to drinkName, ARG_DRINK_QUERY to query)
    }

    private val drinkName: String by lazy {
        arguments?.getString(ARG_DRINK_NAME).orEmpty()
    }

    private val query by lazy {
        arguments?.getString(ARG_DRINK_QUERY).orEmpty()
    }


    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var drinksRepository: DrinksRepository

    private val presenter: DrinksPresenter by moxyPresenter {
        DrinksPresenter(
            drinksRepository = drinksRepository,
            router = router,
            schedulers = schedulers,
            drinkName = drinkName,
            query = query
        )
    }

    private val viewBinding: ViewDrinksBinding by viewBinding()
    private val drinksAdapter = DrinksAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.drinks.adapter = drinksAdapter
    }

    override fun showDrinks(drinks: List<DrinksViewModel>) {
        drinksAdapter.submitList(drinks)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(
            requireContext(),
            "Sorry, we can't find recipe for this drink:(",
            Toast.LENGTH_LONG
        ).show()
        Log.d("ERROR", error.message.toString())
        presenter.onErrorDrink()
    }


    override fun onDrinkPicked(drink: DrinksViewModel) {
        presenter.displayDrink(drink)
    }


}

