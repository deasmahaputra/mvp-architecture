package com.deasmahaputra.mvparchitecture.movies

import com.deasmahaputra.mvparchitecture.network.response.MovieResponse

interface MovieView{

    fun startLoading()

    fun stopLoading()

    fun showDataMovie(data : MovieResponse)
}