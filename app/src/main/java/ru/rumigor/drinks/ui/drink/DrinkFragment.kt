package ru.rumigor.drinks.ui.drink


import android.widget.Toast
import androidx.fragment.app.Fragment
import moxy.ktx.moxyPresenter
import ru.rumigor.drinks.R
import ru.rumigor.drinks.arguments
import ru.rumigor.drinks.databinding.ViewDrinkFragmentBinding
import ru.rumigor.drinks.scheduler.Schedulers
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.ui.DrinksViewModel
import ru.rumigor.drinks.ui.abs.AbsFragment
import javax.inject.Inject

class DrinkFragment: AbsFragment(R.layout.view_drink_fragment), DrinkView {

    companion object Factory{

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
    lateinit var drinksRepository: DrinksRepository



    @Suppress("unused")
    private val presenter: DrinkPresenter by moxyPresenter {
        DrinkPresenter(
            drinkName = drinkName,
            drinksRepository = drinksRepository,
            schedulers = schedulers
        )
    }

    private val viewBinding: ViewDrinkFragmentBinding by viewBinding()


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