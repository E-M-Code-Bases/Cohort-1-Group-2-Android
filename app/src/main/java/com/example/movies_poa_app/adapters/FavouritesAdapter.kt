package com.example.movies_poa_app.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_poa_app.R
import com.example.movies_poa_app.databinding.FavouriteItemBinding
import com.example.movies_poa_app.model.Movie
import com.squareup.picasso.Picasso


class FavouritesAdapter(private var context: Context, var movies: List<Movie>): RecyclerView.Adapter<FavouritesAdapter.ViewHolder> () {

    inner class ViewHolder(val binding: FavouriteItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: FavouriteItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.favourite_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.movie = movie

        val posterUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"

        Picasso.get()
            .load(posterUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.posterImageView)
        holder.binding.root.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("movie", movie)
            }

            holder.binding.root.findNavController()
                .navigate(R.id.action_singleMovieFragment_to_playFragment, bundle)
        }

    }
}

