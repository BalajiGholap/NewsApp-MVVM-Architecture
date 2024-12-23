package com.bala.newsapp_mvvm_architecture

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.bala.newsapp_mvvm_architecture.appui.MenuList
import com.bala.newsapp_mvvm_architecture.ui.theme.NewsAppMVVMArchitectureTheme
import com.bala.newsapp_mvvm_architecture.uistate.NetworkResult
import com.bala.newsapp_mvvm_architecture.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenuList()
        }

        /*newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        newsViewModel.sources.observe(this){response ->
            when(response){
                is NetworkResult.Failuer -> {
                    Log.i("SourcesFaild","${response.data}")
                }
                is NetworkResult.Loading -> {
                    Log.i("Loaddingg","Loaaddingg")
                }
                is NetworkResult.Success -> {
                    Log.i("SourceResponse","${response.data}")
                }
            }
        }*/
    }

    override fun onResume() {
        super.onResume()
        //newsViewModel.getTopHeadlines()
        //newsViewModel.getCars()
        //newsViewModel.getSources()
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppMVVMArchitectureTheme {
        //Greeting("Android")
        MenuList()
    }
}