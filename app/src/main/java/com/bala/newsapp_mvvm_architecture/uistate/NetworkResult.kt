package com.bala.newsapp_mvvm_architecture.uistate

sealed class NetworkResult<T>(val data: T?=null, val error: String?=null) {
    class Success<T>(data: T?): NetworkResult<T>(data = data)
    class Failuer<T>(error: String?): NetworkResult<T>(error = error)
    class Loading<T>(): NetworkResult<T>()
}