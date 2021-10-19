package ru.rumigor.drinks.ui.drinks.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.rumigor.drinks.ui.DrinksViewModel

object DrinkDiff : DiffUtil.ItemCallback<DrinksViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: DrinksViewModel, newItem: DrinksViewModel): Boolean {
        return oldItem.strDrink == newItem.strDrink
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DrinksViewModel, newItem: DrinksViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: DrinksViewModel, newItem: DrinksViewModel) = payload

}
