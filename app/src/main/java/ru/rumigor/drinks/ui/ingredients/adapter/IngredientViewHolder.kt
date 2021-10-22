package ru.rumigor.drinks.ui.ingredients.adapter

import android.view.View
import android.widget.CheckedTextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.rumigor.drinks.databinding.ViewIngredientBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.rumigor.drinks.ui.IngredientsViewModel




class IngredientViewHolder(view: View, private val delegate: IngredientsAdapter.Delegate?) : ViewHolder(view), View.OnClickListener {

    private val viewBiding: ViewIngredientBinding by viewBinding()
    var mCheckedTextView: CheckedTextView? = null

    fun bind(ingredient: IngredientsViewModel, delegate: IngredientsAdapter.Delegate?) {
        with(viewBiding) {
            viewBiding.ingredientCheckBox.text = ingredient.strIngredient1
            viewBiding.ingredientCheckBox.isChecked =
                IngredientsAdapter(delegate).itemStateArray.get(adapterPosition, false)
            ingredientCheckBox.setOnClickListener(this@IngredientViewHolder)


        }
    }

    override fun onClick(v: View?) {
        val itemStateArray = IngredientsAdapter(delegate).itemStateArray
        if (!itemStateArray.get(adapterPosition, false)){
            with(viewBiding){
                viewBiding.ingredientCheckBox.isChecked = true
                itemStateArray.put(adapterPosition, true)
            }
        } else {
            viewBiding.ingredientCheckBox.isChecked = false
            itemStateArray.put(adapterPosition, false)
        }
    }


}