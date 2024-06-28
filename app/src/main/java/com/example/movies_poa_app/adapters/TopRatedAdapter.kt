
package com.example.movies_poa_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_poa_app.R
import com.example.movies_poa_app.databinding.ItemTopmovieBinding
import com.example.movies_poa_app.model.Movie
import com.squareup.picasso.Picasso

class TopRatedAdapter (private var context: Context, private var list: List<Movie>): RecyclerView.Adapter<TopRatedAdapter.ViewHolder> () {
    inner class ViewHolder( val binding: ItemTopmovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemTopmovieBinding = ItemTopmovieBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]
        holder.binding.movieTitle.text = movie.original_title
        holder.binding.movieOverview.text = movie.overview
        holder.binding.movieRating.text = movie.vote_count.toString()

        val posterUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"

        Picasso.get()
            .load(posterUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.moviePoster)

    }

}

