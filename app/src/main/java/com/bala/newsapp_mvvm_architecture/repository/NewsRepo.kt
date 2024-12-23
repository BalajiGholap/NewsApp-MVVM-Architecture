package com.bala.newsapp_mvvm_architecture.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bala.newsapp_mvvm_architecture.model.topheadlines.NewsData
import com.bala.newsapp_mvvm_architecture.model.sources.Sources
import com.bala.newsapp_mvvm_architecture.retrofit.NewsApi
import com.bala.newsapp_mvvm_architecture.uistate.NetworkResult
import com.bala.newsapp_mvvm_architecture.utils.FullScreenLoadingManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class NewsRepo @Inject constructor(private val newsApi: NewsApi) {
    private val _topHeadlines: MutableLiveData<NetworkResult<NewsData>> = MutableLiveData()
    val topHeadlines: LiveData<NetworkResult<NewsData>> get() = _topHeadlines

    suspend fun getTopHeadlines(){
        _topHeadlines.value = NetworkResult.Loading()
        try {
            val result = newsApi.getTopHeadlines()
            if (result.isSuccessful && result.body()!=null){
                Log.i("TopHeadlinesResponsssee","${result.body()}")
                _topHeadlines.value = NetworkResult.Success(result.body()!!)
            }else{
                _topHeadlines.value = NetworkResult.Failuer(result.message())
                Log.i("FaildMessage","${result.message()}")
            }
        }catch (e: Exception){
            _topHeadlines.value = NetworkResult.Failuer(e.message.toString())
        }
    }


    private val _sources: MutableLiveData<NetworkResult<Sources>> = MutableLiveData()
    val sources: LiveData<NetworkResult<Sources>> get() = _sources

    suspend fun getSources(){
        _sources.value = NetworkResult.Loading()
        try {
            val result = newsApi.getSources()
            if (result.isSuccessful && result.body()!=null){
                Log.i("SourcesResponsssee","${result.body()}")
                _sources.value = NetworkResult.Success(result.body()!!)
            }else{
                _sources.value = NetworkResult.Failuer(result.message())
                Log.i("FaildMSourcesResponsssee","${result.message()}")
            }
        }catch (e: Exception){
            _sources.value = NetworkResult.Failuer(e.message.toString())
        }
    }
}