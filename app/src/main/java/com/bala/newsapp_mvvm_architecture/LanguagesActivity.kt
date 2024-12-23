package com.bala.newsapp_mvvm_architecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bala.newsapp_mvvm_architecture.appui.LanguageList

class LanguagesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LanguageList(getLanguagesList())
        }
    }
    fun getLanguagesList(): List<String>{
        val languages = listOf("ar","de","en","es","fr","he","it","nl","no","pt","ru","sv","ud","zh")
        return languages
    }
}
