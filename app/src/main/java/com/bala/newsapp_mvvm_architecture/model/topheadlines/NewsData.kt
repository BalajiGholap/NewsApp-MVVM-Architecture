package com.bala.newsapp_mvvm_architecture.model.topheadlines

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)