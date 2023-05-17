package com.example.cybernews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.cybernews.NewsApplication
import com.example.cybernews.data.NewsRepository

class NewsViewModel(
    newsRepository: NewsRepository
) : ViewModel() {
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NewsApplication)
                val newsRepository = application.appContainer.newsRepository
                NewsViewModel(newsRepository = newsRepository)
            }
        }
    }
}