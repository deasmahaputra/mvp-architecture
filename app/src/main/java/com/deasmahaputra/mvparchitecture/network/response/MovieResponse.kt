package com.deasmahaputra.mvparchitecture.network.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(@SerializedName("results") var popularMovie : MutableList<PopularMovies> = mutableListOf()){

    data class PopularMovies(@SerializedName("id") var id: Int? = null,
                             @SerializedName("title") var title: String? = null,
                             @SerializedName("poster_path") var poster_path: String? = null,
                             @SerializedName("vote_average") var vote_averange: Double? = null)
}