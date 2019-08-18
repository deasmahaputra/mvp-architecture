package com.deasmahaputra.mvparchitecture.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deasmahaputra.mvparchitecture.R
import com.deasmahaputra.mvparchitecture.base.extension.network.BaseUrl
import com.deasmahaputra.mvparchitecture.network.response.MovieResponse
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class ListMovieAdapter(private val context: Context, private val listener : AdapterOnClickListener) : RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder>(){

    var listMovie : MutableList<MovieResponse.PopularMovies> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolder {
        return ListMovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_popular_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: ListMovieViewHolder, position: Int) {
        holder.bindData(listMovie[position], listener)
    }

    fun setDataMovie(data : MovieResponse){
        listMovie.clear()
        listMovie.addAll(data.popularMovie)
        notifyDataSetChanged()
    }

    class ListMovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindData(data : MovieResponse.PopularMovies, listener: AdapterOnClickListener){
            with(data){
                Glide.with(itemView).load(BaseUrl.BASE_IMAGE_URL + poster_path).into(itemView.moviesImageView)
                itemView.titleTextView.text = title
                itemView.setOnClickListener{
                    listener.setOnClickListener(id?: 0)
                }
            }
        }
    }

    interface AdapterOnClickListener{
        fun setOnClickListener(id : Int)
    }
}