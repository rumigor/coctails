package ru.rumigor.drinks.ui.drink

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.rumigor.drinks.DrinksApp
import ru.rumigor.drinks.R
import ru.rumigor.drinks.arguments
import ru.rumigor.drinks.data.di.DrinkComponent
import ru.rumigor.drinks.data.drink.DrinkRepository
import ru.rumigor.drinks.databinding.ViewDrinkFragmentBinding
import ru.rumigor.drinks.scheduler.Schedulers
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.rumigor.drinks.ui.DrinksViewModel
import javax.inject.Inject

class DrinkFragment: MvpAppCompatFragment(R.layout.view_drink_fragment), DrinkView {

    companion object {

        private const val ARG_DRINK_ID = "arg_drink_id"

        fun newInstance(idDrink: String): Fragment =
            DrinkFragment()
                .arguments(ARG_DRINK_ID to idDrink)
    }

    private val drinkName: String by lazy {
        arguments?.getString(ARG_DRINK_ID).orEmpty()
    }

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var drinkRepository: DrinkRepository

    @Inject
    lateinit var router: Router

    private var drinkComponent: DrinkComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        drinkComponent =
            (requireActivity().application as? DrinksApp)
                ?.drinksApplicationComponent
                ?.drinkComponent()
                ?.build()
                ?.also { it.inject(this) }
    }

    @Suppress("unused")
    private val presenter: DrinkPresenter by moxyPresenter {
        DrinkPresenter(
            drinkName = drinkName,
            drinkRepository = drinkRepository,
            schedulers = schedulers,
            router = router
        )
    }

    private val viewBinding: ViewDrinkFragmentBinding by viewBinding()

    override fun onDestroy() {
        super.onDestroy()
        drinkComponent = null
    }

    override fun showDrink(drink: DrinksViewModel) {
        viewBinding.drinkTitle.text = drink.strDrink
        viewBinding.alcStatus.text = drink.strAlcoholic
        viewBinding.instruction.text = drink.strInstructions
        context?.let {
            Glide.with(it)
                .load(drink.strDrinkThumb)
                .into(viewBinding.drinkPic)
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }
}