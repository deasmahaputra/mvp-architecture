package com.deasmahaputra.mvparchitecture.movies.detail

import android.os.Bundle
import com.deasmahaputra.mvparchitecture.R
import com.deasmahaputra.mvparchitecture.base.BaseActivity

class DetailMovieActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
    }
}