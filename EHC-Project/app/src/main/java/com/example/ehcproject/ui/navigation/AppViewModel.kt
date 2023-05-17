package com.example.ehcproject.ui.navigation

import androidx.lifecycle.ViewModel
import com.example.ehcproject.model.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(News().bookmark)
    val uiState = _uiState.asStateFlow()
    init {

    }
}