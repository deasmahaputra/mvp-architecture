package com.deasmahaputra.mvparchitecture.base.extension.network

interface ApiResponseCallback<T> {
    fun onSuccess(response: T)
    fun onError(error: NetworkError)
}