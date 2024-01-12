package com.mihser.foodtalker.ui.screens

import android.net.Uri
import androidx.annotation.DrawableRes

data class DishHolder(
    val name: String,
    val description: String,
    @DrawableRes val localDrawableRes: Int? = null,
)
