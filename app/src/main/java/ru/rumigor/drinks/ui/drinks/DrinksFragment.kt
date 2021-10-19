package ru.rumigor.drinks.ui.drinks

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

import ru.rumigor.drinks.ui.drinks.adapter.DrinksAdapter

import com.github.terrakok.cicerone.Router
import ru.rumigor.drinks.DrinksApp
import ru.rumigor.drinks.R
import ru.rumigor.drinks.arguments
import ru.rumigor.drinks.data.di.DrinksComponent
import ru.rumigor.drinks.data.drinks.DrinksRepository
import ru.rumigor.drinks.databinding.ViewDrinksBinding
import ru.rumigor.drinks.scheduler.Schedulers
import ru.rumigor.drinks.ui.DrinksViewModel
import javax.inject.Inject

class DrinksFragment: MvpAppCompatFragment(R.layout.view_drinks), DrinksView {

    companion object {

        fun newInstance(): Fragment =
            DrinksFragment()
                .arguments()

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
            schedulers = schedulers
        )
    }

    private val viewBinding: ViewDrinksBinding by viewBinding()
    private val drinksAdapter = DrinksAdapter()

    private var drinksComponent: DrinksComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        drinksComponent =
            (requireActivity().application as? DrinksApp)
                ?.drinksApplicationComponent
                ?.drinksComponent()
                ?.build()
                ?.also { it.inject(this) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.drinks.adapter = drinksAdapter
    }

    override fun showDrinks(drinks: List<DrinksViewModel>) {
        drinksAdapter.submitList(drinks)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
        Log.d("ERROR", error.message.toString())
    }

//    override fun onUserPicked(user: GitHubUserViewModel) =
//        presenter.displayUser(user)

    override fun onDestroy() {
        super.onDestroy()
        drinksComponent = null
    }

}

