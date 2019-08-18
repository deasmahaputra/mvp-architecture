package com.deasmahaputra.mvparchitecture.base.extension.network

import com.deasmahaputra.mvparchitecture.network.response.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService{

    @GET(BaseUrl.API + BaseUrl.POPULAR)
    fun getPopularMovie(
        @Query("key") key : String) : Observable<MovieResponse>
}