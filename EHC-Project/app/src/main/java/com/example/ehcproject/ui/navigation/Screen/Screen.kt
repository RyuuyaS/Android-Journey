package com.example.ehcproject.ui.navigation.Screen

import androidx.annotation.StringRes
import com.example.ehcproject.R

enum class Screen(@StringRes val AppBarText: Int) {
    MainScreen(R.string.main_screen),
    MemberScreen(R.string.members_screen),
    InterestsScreen(R.string.members_screen),
}