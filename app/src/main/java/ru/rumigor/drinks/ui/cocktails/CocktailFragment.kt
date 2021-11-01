//package ru.rumigor.drinks.ui.cocktails
//
//
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import moxy.ktx.moxyPresenter
//
//import ru.rumigor.drinks.ui.cocktails.adapter.CocktailsAdapter
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.github.terrakok.cicerone.Router
//import ru.rumigor.drinks.R
//import ru.rumigor.drinks.arguments
//import ru.rumigor.drinks.data.drinks.DrinksRepository
//import ru.rumigor.drinks.databinding.ViewDrinksBinding
//import ru.rumigor.drinks.scheduler.Schedulers
//import ru.rumigor.drinks.ui.CocktailsViewModel
//import ru.rumigor.drinks.ui.abs.AbsFragment
//import javax.inject.Inject
//
//class CocktailFragment : AbsFragment(R.layout.view_drinks), CocktailsView, CocktailsAdapter.Delegate {
//
//    companion object {
//
//        private const val ARG_DRINK_NAME = "arg_drink_name"
//        private const val ARG_INGRD_NAME = "arg_ingrd_name"
//
//        fun newInstance(drinkName: String, query: String): Fragment =
//            CocktailFragment()
//                .arguments(ARG_DRINK_NAME to drinkName, ARG_INGRD_NAME to query)
//    }
//
//    private val drinkName: String by lazy {
//        arguments?.getString(ARG_DRINK_NAME).orEmpty()
//    }
//
//    private val query: String by lazy {
//        arguments?.getString(ARG_INGRD_NAME).orEmpty()
//    }
//
//    @Inject
//    lateinit var router: Router
//
//    @Inject
//    lateinit var schedulers: Schedulers
//
//    @Inject
//    lateinit var drinksRepository: DrinksRepository
//
//    private val presenter: CocktailsPresenter by moxyPresenter {
//        CocktailsPresenter(
//            drinksRepository = drinksRepository,
//            router = router,
//            schedulers = schedulers,
//            drinkName = drinkName,
//            query = query
//        )
//    }
//
//    private val viewBinding: ViewDrinksBinding by viewBinding()
//    private val drinksAdapter = CocktailsAdapter(delegate = this)
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        viewBinding.drinks.adapter = drinksAdapter
//    }
//
//    override fun showDrinks(drinks: List<CocktailsViewModel>) {
//        drinksAdapter.submitList(drinks)
//    }
//
//    override fun showError(error: Throwable) {
//        if (error.message == "The mapper function returned a null value.") {
//            Toast.makeText(
//                requireContext(),
//                "Sorry, we can't find recipe for this drink:(",
//                Toast.LENGTH_LONG
//            ).show()
//        }
//        Log.d("ERROR", error.message.toString())
//        presenter.onErrorDrink()
//    }
//
//
//    override fun onDrinkPicked(cocktail: CocktailsViewModel) {
//        presenter.displayDrink(cocktail)
//    }
//
//
//}
//