package com.example.ehcproject.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class News(
    @DrawableRes val imageInt: Int = 0,
    @StringRes val title: Int = 0,
    @StringRes val date: Int = 0,
    @StringRes val description: Int = 0,
    val bookmark: Boolean = false
)
