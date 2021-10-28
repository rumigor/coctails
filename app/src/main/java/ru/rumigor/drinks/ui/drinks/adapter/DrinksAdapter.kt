package ru.rumigor.drinks.ui.drinks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.rumigor.drinks.R
import ru.rumigor.drinks.ui.DrinksViewModel


class DrinksAdapter() :
    ListAdapter<DrinksViewModel, DrinkViewHolder>(DrinkDiff) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder =
        DrinkViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_drink, parent, false)
        )

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) =
        holder.bind(getItem(position))

}