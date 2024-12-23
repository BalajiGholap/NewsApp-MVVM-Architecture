package com.bala.newsapp_mvvm_architecture.retrofit

import com.bala.newsapp_mvvm_architecture.model.Cars
import com.bala.newsapp_mvvm_architecture.model.topheadlines.NewsData
import com.bala.newsapp_mvvm_architecture.model.sources.Sources
import com.bala.newsapp_mvvm_architecture.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("cars")
    suspend fun getCars(): Response<List<Cars>>

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<NewsData>

    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<Sources>

}