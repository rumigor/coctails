package ru.rumigor.drinks.ui.cocktails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.rumigor.drinks.R
import ru.rumigor.drinks.ui.CocktailsViewModel
import ru.rumigor.drinks.ui.DrinksViewModel


class CocktailsAdapter(private val delegate: Delegate?) :
    ListAdapter<CocktailsViewModel, CocktailViewHolder>(CocktailDiff) {

    interface Delegate {
        fun onDrinkPicked(cocktail: CocktailsViewModel)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder =
        CocktailViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_drink, parent, false)
        )

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)
}