package com.example.cybernews.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun CyberNewsApp() {
    val viewModel: NewsViewModel = viewModel(factory = NewsViewModel.Factory)

}