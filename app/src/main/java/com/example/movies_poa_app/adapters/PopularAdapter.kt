package com.example.movies_poa_app.adapters

import android.os.Bundle
import  com.example.movies_poa_app.model.Movie
import android.view.LayoutInflater
import com.squareup.picasso.Picasso
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_poa_app.R
import com.example.movies_poa_app.databinding.ItemMovieBinding

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movieTitle.text = movie.original_title
            binding.description.text = movie.overview

            val posterUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"

            Picasso.get()
                .load(posterUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.moviePoster)

            binding.root.setOnClickListener{
                val bundle = Bundle().apply {
                    putSerializable("movie", movie)
                }
                binding.root.findNavController().navigate(R.id.action_singleMovieFragment_to_playFragment, bundle)

            }
        }
    }
  private val diff =  object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    val moviesList = AsyncListDiffer(this, diff)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount() = moviesList.currentList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList.currentList[position]
        holder.bind(movie)
    }
}

