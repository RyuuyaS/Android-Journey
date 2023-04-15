package com.example.ehcproject.ui.navigation

import androidx.lifecycle.ViewModel
import com.example.ehcproject.model.News
import kotlinx.coroutines.flow.MutableStateFlow

class AppViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(News().bookmark)

    init {
    }
}