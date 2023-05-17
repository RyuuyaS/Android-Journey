package com.example.cybernews

import android.app.Application
import com.example.cybernews.data.AppContainer
import com.example.cybernews.data.DefaultAppContainer

class NewsApplication : Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer()
    }
}