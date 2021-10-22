package ru.rumigor.drinks.ui.ingredients

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class IngredientsScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        IngredientsFragment.newInstance()
}