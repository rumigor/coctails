package ru.rumigor.drinks.ui.ingredients.adapter

import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.rumigor.drinks.databinding.ViewIngredientBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.rumigor.drinks.ui.IngredientsViewModel



class IngredientViewHolder(view: View, private val delegate: IngredientsAdapter.Delegate?) : ViewHolder(view) {

    private val viewBiding: ViewIngredientBinding by viewBinding()



    fun bind(ingredient: IngredientsViewModel, delegate: IngredientsAdapter.Delegate?) {
        viewBiding.ingredientCheckBox.text = ingredient.strIngredient1
        viewBiding.ingredientCheckBox.isChecked = ingredient.checked
        viewBiding.ingredientCheckBox.setOnClickListener {
            if (ingredient.checked){
                (it as CheckBox).isChecked = false
                ingredient.checked = false
                delegate?.onIngredientDeselected(ingredient.strIngredient1)
                delegate?.updateStatus(ingredient.strIngredient1, false)
            } else {
                (it as CheckBox).isChecked = true
                ingredient.checked = true
                delegate?.onIngredientSelected(ingredient.strIngredient1)
                delegate?.updateStatus(ingredient.strIngredient1, true)
            }
        }
    }




}