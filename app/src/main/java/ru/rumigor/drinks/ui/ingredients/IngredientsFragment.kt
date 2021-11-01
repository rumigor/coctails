package ru.rumigor.drinks.ui.ingredients

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
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
    private var stringBuffer = StringBuffer()



    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
        Log.d("ERROR", error.message.toString())
    }

    override fun onIngredientSelected(ingredient: String) {
        stringBuffer.append(",$ingredient")
    }

    override fun onIngredientDeselected(ingredient: String) {
        val text: String = stringBuffer.toString().replace(",$ingredient", "")
        stringBuffer = StringBuffer(text)
        println(stringBuffer)
    }

    override fun updateStatus(strIngredient: String, checked: Boolean) {
        presenter.updateStatus(strIngredient, checked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.ingredientsList.adapter = ingredientsAdapter
        viewBinding.searchButton.setOnClickListener {
            if (stringBuffer.isNotEmpty()) {
                stringBuffer.deleteCharAt(0)
                presenter.deselect()
                presenter.showDrinks(stringBuffer.toString())
                stringBuffer = StringBuffer("")
            }
        }
        viewBinding.filter.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               query?.let { presenter.filterIngredients(query) }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        }
        )
        viewBinding.filter.setOnCloseListener{
            presenter.loadAllIngredients()
            return@setOnCloseListener true
        }
    }

    override fun loadIngredients(ingredients: List<IngredientsViewModel>) {
        ingredientsAdapter.submitList(ingredients)
    }
}