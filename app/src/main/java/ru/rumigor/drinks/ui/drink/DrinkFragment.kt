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
import java.lang.StringBuilder
import javax.inject.Inject

class DrinkFragment : AbsFragment(R.layout.view_drink_fragment), DrinkView {

    companion object Factory {

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
        viewBinding.drinkCategory.text = drink.strCategory
        val ingredients = listOf(
            drink.strIngredient1,
            drink.strIngredient2,
            drink.strIngredient3,
            drink.strIngredient4,
            drink.strIngredient5,
            drink.strIngredient6,
            drink.strIngredient7,
            drink.strIngredient8,
            drink.strIngredient9,
            drink.strIngredient10,
            drink.strIngredient11,
            drink.strIngredient12,
            drink.strIngredient13,
            drink.strIngredient14,
            drink.strIngredient15
        )
        val measures = listOf(
            drink.strMeasure1,
            drink.strMeasure2,
            drink.strMeasure3,
            drink.strMeasure4,
            drink.strMeasure5,
            drink.strMeasure6,
            drink.strMeasure7,
            drink.strMeasure8,
            drink.strMeasure9,
            drink.strMeasure10,
            drink.strMeasure11,
            drink.strMeasure12,
            drink.strMeasure13,
            drink.strMeasure14,
            drink.strMeasure15
        )
        val stringBuilder = StringBuilder(viewBinding.ingredients.text.toString())
        for (i in 0..14) {
            ingredients[i]?.let {
                stringBuilder.append("${ingredients[i]} ")
                measures[i]?.let { stringBuilder.append("(${measures[i]})") }
                stringBuilder.append(", ")
            }
        }
        stringBuilder.deleteRange(stringBuilder.length - 2, stringBuilder.length - 1)
        viewBinding.ingredients.text = stringBuilder

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