package com.example.cybernews.data

import com.example.cybernews.network.NewsApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val newsRepository: NewsRepository
}

class DefaultAppContainer() : AppContainer {
    private val baseUrl = "https://newsapi.org/v2/everything"
    private val apiKey = "1ac280854f274e199b379c94a70d2376"

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val retrofitService: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }


    override val newsRepository: NewsRepository by lazy {
        NetworkNewsRepository(retrofitService)
    }
}