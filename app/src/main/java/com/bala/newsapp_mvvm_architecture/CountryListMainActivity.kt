package com.bala.newsapp_mvvm_architecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bala.newsapp_mvvm_architecture.appui.CountryList

class CountryListMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryList(getCountryList())
        }
    }
    fun getCountryList(): List<String>{
        val countryList = listOf("ae","ar","at","au","be","bg","br","ca","ch","cn","co","cu","cz","de","eg","fr","gb","gr","hk","hu","id","ie","il","in","us","as","es","gs","is","kt","ht","rt","wu","au","sv","za")
        return countryList
    }
}
