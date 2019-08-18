package com.deasmahaputra.mvparchitecture.base.extension.network

class BaseUrl{
    companion object{
        const val API = "/3/movie"
        const val POPULAR = "/popular"
        const val TOP_RATED = "/top_rated"
        const val KEY = "?api_key=e07c8f8a86f13fc0da2bde33c546a505"
        const val ID = "movie_id"
        const val PARAM_ID = "/{$ID}"
        const val BASE_URL = "https://api.themoviedb.org/"
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "e07c8f8a86f13fc0da2bde33c546a505"
        const val DAYS = 7
    }
}