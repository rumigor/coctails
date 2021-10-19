package ru.rumigor.drinks.ui.drinks.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.rumigor.drinks.databinding.ViewDrinkBinding
import ru.rumigor.drinks.setStartDrawableCircleImageFromUri
import ru.rumigor.drinks.ui.DrinksViewModel

class DrinkViewHolder(view: View): ViewHolder(view) {

    private val viewBinding: ViewDrinkBinding by viewBinding()

    fun bind(drink: DrinksViewModel) {
        with(viewBinding) {
            viewBinding.drink.setStartDrawableCircleImageFromUri(drink.strDrinkThumb)
            viewBinding.drink.text = drink.strDrink

        }
    }

}