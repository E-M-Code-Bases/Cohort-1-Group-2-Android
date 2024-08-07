package com.example.movies_poa_app.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_poa_app.R
import com.example.movies_poa_app.databinding.NowplayingItemsBinding
import com.example.movies_poa_app.model.Movie
import com.squareup.picasso.Picasso


class NowPlayingAdapter (private var context: Context, private var list: List<Movie>): RecyclerView.Adapter<NowPlayingAdapter.ViewHolder> () {

    inner class ViewHolder(val binding: NowplayingItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: NowplayingItemsBinding =
            DataBindingUtil.inflate(inflater, R.layout.nowplaying_items, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]
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

