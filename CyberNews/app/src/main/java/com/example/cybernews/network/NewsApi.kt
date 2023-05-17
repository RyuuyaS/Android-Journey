package com.example.cybernews.network

import com.example.cybernews.data.News
import retrofit2.http.GET

interface NewsApi {
    @GET()
    suspend fun getNews(): List<News>
}