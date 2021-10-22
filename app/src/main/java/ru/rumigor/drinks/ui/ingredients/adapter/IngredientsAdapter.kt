package ru.rumigor.drinks.ui.ingredients.adapter

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.rumigor.drinks.R
import ru.rumigor.drinks.ui.IngredientsViewModel

class IngredientsAdapter (private val delegate: Delegate?):
ListAdapter<IngredientsViewModel, IngredientViewHolder>(IngredientDiff){

    private var items = mutableListOf<Model>()
    var itemStateArray = SparseBooleanArray()


    interface Delegate {
        fun onIngredientSelected(ingredient: String)
        fun onIngredientDeselected(ingredient: String)
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

    fun loadItems(ingredients: MutableList<Model>){
        this.items = ingredients
        notifyDataSetChanged()
    }
}