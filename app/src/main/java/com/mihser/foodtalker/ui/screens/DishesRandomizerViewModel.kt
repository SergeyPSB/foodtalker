package com.mihser.foodtalker.ui.screens

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.mihser.foodtalker.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DishesRandomizerViewModel: ViewModel() {

    private val _availableDishesState = MutableStateFlow<List<DishHolder>>(emptyList())
    val availableDishesState = _availableDishesState.asStateFlow()

    fun dropLast() {
        _availableDishesState.value = _availableDishesState.value.dropLast(1)
    }


    init {
        val testData = listOf(
            DishHolder("Pancakes","", R.drawable.food_one),
            DishHolder("Toast with avocado", "", R.drawable.food_two),
            DishHolder("Cake", "", R.drawable.food_three),
        )

        _availableDishesState.value = (testData + testData + testData + testData + testData).shuffled()
    }

    private fun createUriFromDrawable(drawableRes: Int) = Uri.parse("android.resource://your.package.name/$drawableRes")
}