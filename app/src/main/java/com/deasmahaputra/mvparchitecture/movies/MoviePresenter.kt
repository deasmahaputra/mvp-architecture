package com.deasmahaputra.mvparchitecture.movies

import com.deasmahaputra.mvparchitecture.base.extension.network.ApiResponseCallback
import com.deasmahaputra.mvparchitecture.base.extension.network.ApiService
import com.deasmahaputra.mvparchitecture.base.extension.network.NetworkError
import com.deasmahaputra.mvparchitecture.network.response.MovieResponse
import io.reactivex.disposables.CompositeDisposable

class MoviePresenter(private val apiService: ApiService, private val view: MovieView){

    private val composite = CompositeDisposable()

    fun getPopularMovie(apikey : String){
        view.startLoading()
        val fetchMovie = apiService.getPopularMovie(apikey, object : ApiResponseCallback<MovieResponse>{
            override fun onSuccess(response: MovieResponse) {
                view.stopLoading()
                view.showDataMovie(response)
            }

            override fun onError(error: NetworkError) {
                view.stopLoading()
            }

        })

        composite.add(fetchMovie)
    }
}