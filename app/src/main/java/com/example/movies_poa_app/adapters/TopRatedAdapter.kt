package com.example.movies_poa_app.adapters

import com.example.movies_poa_app.databinding.ItemTopmovieBinding
import com.example.movies_poa_app.model.TopRatedMovies
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TopRatedAdapter : ListAdapter<TopRatedMovies, TopRatedAdapter.MovieViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemTopmovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    class MovieViewHolder(private val binding: ItemTopmovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: TopRatedMovies) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<TopRatedMovies>() {
        override fun areItemsTheSame(oldItem: TopRatedMovies, newItem: TopRatedMovies): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: TopRatedMovies, newItem: TopRatedMovies): Boolean = oldItem == newItem
    }
}
