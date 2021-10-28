package ru.rumigor.drinks.ui.drinks

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class DrinksScreen(private val drinkName: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        DrinksFragment.newInstance(drinkName)

}












































