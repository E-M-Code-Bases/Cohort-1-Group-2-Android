package com.example.movies_poa_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_poa_app.R
import com.example.movies_poa_app.databinding.FavouriteItemBinding
import com.example.movies_poa_app.model.Movie

class FavouritesAdapter(
    private var movies: List<Movie>,
    private val clickListener: MovieClickListener
) : RecyclerView.Adapter<FavouritesAdapter.MovieViewHolder>() {

    class MovieViewHolder(val binding: FavouriteItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: FavouriteItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.favourite_item, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.movie = movies[position]
        holder.binding.clickListener = clickListener
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun updateMovies(newMovies: List<Movie>) {
        movies = newMovies
    }
}

interface MovieClickListener {
    fun onMovieClick(movie: Movie)
}
