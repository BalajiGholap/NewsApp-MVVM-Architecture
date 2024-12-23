package com.bala.newsapp_mvvm_architecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}