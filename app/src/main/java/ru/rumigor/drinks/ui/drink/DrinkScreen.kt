package ru.rumigor.drinks.ui.drink

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class DrinkScreen(private val drinkName: String): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        DrinkFragment.newInstance(drinkName)
}