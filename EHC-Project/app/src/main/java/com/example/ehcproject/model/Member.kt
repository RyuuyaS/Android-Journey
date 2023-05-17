package com.example.ehcproject.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Member(
    @StringRes val name: Int,
    @StringRes val quote: Int,
    @DrawableRes val image: Int,
)