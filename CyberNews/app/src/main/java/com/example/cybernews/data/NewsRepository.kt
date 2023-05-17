package com.example.cybernews.data

import com.example.cybernews.network.NewsApi

interface NewsRepository {
    suspend fun getNewsList(): List<News>
}

class NetworkNewsRepository(
    private val newsApiService: NewsApi
) : NewsRepository {
    override suspend fun getNewsList(): List<News> {
        return newsApiService.getNews()
    }
}