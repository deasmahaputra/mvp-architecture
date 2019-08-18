package com.deasmahaputra.mvparchitecture.base.extension.network

import com.deasmahaputra.mvparchitecture.base.extension.configured
import com.deasmahaputra.mvparchitecture.base.extension.subscribe
import com.deasmahaputra.mvparchitecture.network.response.MovieResponse
import io.reactivex.disposables.Disposable

class ApiService(private val networkService: NetworkService){

    fun getPopularMovie(apiKey: String, callback: ApiResponseCallback<MovieResponse>) : Disposable{
        return networkService.getPopularMovie(apiKey)
            .configured()
            .subscribe({ callback.onSuccess(it) }, { error: NetworkError -> callback.onError(error) })
    }
}