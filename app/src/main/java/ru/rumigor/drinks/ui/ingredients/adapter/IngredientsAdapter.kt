package ru.rumigor.drinks.ui.ingredients.adapter

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.rumigor.drinks.R
import ru.rumigor.drinks.ui.IngredientsViewModel

class IngredientsAdapter (private val delegate: Delegate?):
ListAdapter<IngredientsViewModel, IngredientViewHolder>(IngredientDiff){


    interface Delegate {
        fun onIngredientSelected(ingredient: String)
        fun onIngredientDeselected(ingredient: String)
        fun updateStatus(strIngredient:String, checked: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder =
        IngredientViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_ingredient, parent, false),
            delegate
        )

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {

        holder.bind(getItem(position), delegate)
    }

}