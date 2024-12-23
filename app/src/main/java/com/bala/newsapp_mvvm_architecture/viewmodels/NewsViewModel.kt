package com.bala.newsapp_mvvm_architecture.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bala.newsapp_mvvm_architecture.model.topheadlines.NewsData
import com.bala.newsapp_mvvm_architecture.model.sources.Sources
import com.bala.newsapp_mvvm_architecture.repository.NewsRepo
import com.bala.newsapp_mvvm_architecture.uistate.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepo: NewsRepo): ViewModel() {
    val topHeadlines: LiveData<NetworkResult<NewsData>>
        get() = newsRepo.topHeadlines

    fun getTopHeadlines(){
        viewModelScope.launch {
            delay(100)
            newsRepo.getTopHeadlines()
        }

    }

    val sources: LiveData<NetworkResult<Sources>>
        get() = newsRepo.sources

    fun getSources(){
        viewModelScope.launch {
            delay(100)
            newsRepo.getSources()
        }
    }
}