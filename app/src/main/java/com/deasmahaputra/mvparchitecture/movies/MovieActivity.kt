package com.deasmahaputra.mvparchitecture.movies

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.deasmahaputra.mvparchitecture.R
import com.deasmahaputra.mvparchitecture.base.BaseActivity
import com.deasmahaputra.mvparchitecture.base.extension.network.ApiService
import com.deasmahaputra.mvparchitecture.base.extension.network.BaseUrl
import com.deasmahaputra.mvparchitecture.movies.adapter.ListMovieAdapter
import com.deasmahaputra.mvparchitecture.movies.detail.DetailMovieActivity
import com.deasmahaputra.mvparchitecture.network.response.MovieResponse
import kotlinx.android.synthetic.main.activity_movie.*
import javax.inject.Inject

class MovieActivity : BaseActivity(), MovieView, ListMovieAdapter.AdapterOnClickListener{


    @Inject
    lateinit var apiService: ApiService

    private lateinit var adapter : ListMovieAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    lateinit var presenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        getAppComponent().inject(this)

        presenter = MoviePresenter(apiService, this)

        initViews()
    }

    private fun initViews() {
        presenter.getPopularMovie(BaseUrl.API_KEY)

        gridLayoutManager = GridLayoutManager(this, 2)
        movieListRv.layoutManager = gridLayoutManager
        adapter = ListMovieAdapter(this, this)
        movieListRv.adapter = adapter
    }

    override fun startLoading() {
        shimmerViewContainer.startShimmerAnimation()
    }

    override fun stopLoading() {
        shimmerViewContainer.stopShimmerAnimation()
        shimmerViewContainer.visibility = View.INVISIBLE
    }

    override fun showDataMovie(data: MovieResponse) {
        adapter.setDataMovie(data)
    }

    override fun setOnClickListener(id : Int) {
        val intent = Intent(this, DetailMovieActivity::class.java)
        startActivity(intent)
    }

}