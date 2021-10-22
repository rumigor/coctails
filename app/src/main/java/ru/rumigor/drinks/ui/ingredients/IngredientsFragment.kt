package ru.rumigor.drinks.ui.ingredients

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter
import ru.rumigor.drinks.R
import ru.rumigor.drinks.arguments
import ru.rumigor.drinks.data.drinks.IngredientsRepository
import ru.rumigor.drinks.databinding.ViewSearchbyingredientsBinding
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.IngredientsViewModel
import ru.rumigor.drinks.ui.abs.AbsFragment
import ru.rumigor.drinks.ui.ingredients.adapter.IngredientsAdapter
import java.lang.StringBuilder
import java.util.regex.Pattern
import javax.inject.Inject

class IngredientsFragment: AbsFragment(R.layout.view_searchbyingredients), IngredientsView, IngredientsAdapter.Delegate {

    companion object {
        fun newInstance(): Fragment =
            IngredientsFragment()
                .arguments()
    }

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var schedulers: Schedulers
    @Inject
    lateinit var ingredientsRepository: IngredientsRepository

    private val presenter: IngredientsPresenter by moxyPresenter {
        IngredientsPresenter(
            ingredientsRepository,
            router,
            schedulers
        )
    }

    private val viewBinding: ViewSearchbyingredientsBinding by viewBinding()
    private val ingredientsAdapter = IngredientsAdapter(delegate = this)
    private var stringBuilder = StringBuilder()



    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
        Log.d("ERROR", error.message.toString())
    }

    override fun onIngredientSelected(ingredient: String) {
        stringBuilder.append("$ingredient,")
    }

    override fun onIngredientDeselected(ingredient: String) {
        val regex = "[^$ingredient,]"
        val sb = StringBuilder()
        val pattern = Pattern.compile(regex, Pattern.MULTILINE)
        val matcher = pattern.matcher(stringBuilder)

        while (matcher.find()) {
            sb.append(matcher.group(0))
        }
        stringBuilder = sb
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.ingredientsList.adapter = ingredientsAdapter
        viewBinding.searchButton.setOnClickListener {
            if (stringBuilder.isNotEmpty()) {
                stringBuilder.deleteCharAt(stringBuilder.lastIndex)
                print(stringBuilder)
                presenter.showDrinks(stringBuilder.toString())
            }
        }
    }

    override fun loadIngredients(ingredients: List<IngredientsViewModel>) {
        ingredientsAdapter.submitList(ingredients)
    }
}