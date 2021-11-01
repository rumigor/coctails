//package ru.rumigor.drinks.ui.cocktails.adapter
//
//import android.annotation.SuppressLint
//import androidx.recyclerview.widget.DiffUtil
//import ru.rumigor.drinks.ui.CocktailsViewModel
//import ru.rumigor.drinks.ui.DrinksViewModel
//
//object CocktailDiff : DiffUtil.ItemCallback<CocktailsViewModel>() {
//
//    private val payload = Any()
//
//    override fun areItemsTheSame(oldItem: CocktailsViewModel, newItem: CocktailsViewModel): Boolean {
//        return oldItem.strDrink == newItem.strDrink
//    }
//
//    @SuppressLint("DiffUtilEquals")
//    override fun areContentsTheSame(oldItem: CocktailsViewModel, newItem: CocktailsViewModel): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun getChangePayload(oldItem: CocktailsViewModel, newItem: CocktailsViewModel) = payload
//
//}
