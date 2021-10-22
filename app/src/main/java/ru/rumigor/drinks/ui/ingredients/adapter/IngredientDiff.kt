package ru.rumigor.drinks.ui.ingredients.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.rumigor.drinks.ui.IngredientsViewModel


object IngredientDiff: DiffUtil.ItemCallback<IngredientsViewModel>() {
    private val payload = Any()

    override fun areItemsTheSame(oldItem: IngredientsViewModel, newItem: IngredientsViewModel): Boolean {
        return oldItem.strIngredient1 == newItem.strIngredient1
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: IngredientsViewModel, newItem: IngredientsViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: IngredientsViewModel, newItem: IngredientsViewModel) =
        payload
}