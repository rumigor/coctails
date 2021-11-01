package ru.rumigor.drinks.ui.cocktails

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.rumigor.drinks.ui.drinks.DrinksFragment

class CocktailScreen(private val drinkName: String, private val query: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        CocktailFragment.newInstance(drinkName, query)

}












































