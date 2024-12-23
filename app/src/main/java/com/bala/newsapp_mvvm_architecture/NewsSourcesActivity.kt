package com.bala.newsapp_mvvm_architecture

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.bala.newsapp_mvvm_architecture.appui.FullScreenLoader
import com.bala.newsapp_mvvm_architecture.appui.NewsSources
import com.bala.newsapp_mvvm_architecture.uistate.NetworkResult
import com.bala.newsapp_mvvm_architecture.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsSourcesActivity : ComponentActivity() {
    lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val newsSourceResult  = newsViewModel.sources.observeAsState().value
            when(newsSourceResult){
                is NetworkResult.Failuer -> {
                    Log.i("Faild","${newsSourceResult.data}")
                }
                is NetworkResult.Loading -> {
                    Log.i("Loaddingg","Loaaddingg")
                    FullScreenLoader(true)
                }
                is NetworkResult.Success -> {
                    val result = newsSourceResult.data?.sources
                    NewsSources(result)
                }
                null -> {
                    Log.i("NoData","Nullll")
                }
            }
        }
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        newsViewModel.getSources()
    }
}
