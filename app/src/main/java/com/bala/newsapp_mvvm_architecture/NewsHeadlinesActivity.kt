package com.bala.newsapp_mvvm_architecture

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.bala.newsapp_mvvm_architecture.appui.FullScreenLoader
import com.bala.newsapp_mvvm_architecture.appui.TopHeadlines
import com.bala.newsapp_mvvm_architecture.uistate.NetworkResult
import com.bala.newsapp_mvvm_architecture.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsHeadlinesActivity : ComponentActivity() {
    lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        enableEdgeToEdge()
        setContent {
            val topHeadlinesResult  = newsViewModel.topHeadlines.observeAsState().value
            when(topHeadlinesResult){
                is NetworkResult.Failuer -> {
                    Log.i("Faild","${topHeadlinesResult.data}")
                }
                is NetworkResult.Loading -> {
                    Log.i("Loaddingg","Loaaddingg")
                    FullScreenLoader(true)
                }
                is NetworkResult.Success -> {
                    val result = topHeadlinesResult.data?.articles
                    TopHeadlines(result)
                }
                null -> {
                    Log.i("$TAG: NoData","Nullll")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        newsViewModel.getTopHeadlines()
    }
}

