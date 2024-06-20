package com.example.movies_poa_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_poa_app.R
import com.example.movies_poa_app.databinding.NowplayingItemsBinding
import com.example.movies_poa_app.model.Movie
import com.squareup.picasso.Picasso
/*
class NowPlayingAdapter (private var con: Context, var list: List<Movie>): RecyclerView.Adapter<NowPlayingAdapter.ViewHolder> () {
      inner class ViewHolder(binding: NowplayingItemsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(con)
        val binding= DataBindingUtil.inflate<NowplayingItemsBinding>(inflater, R.layout.nowplaying_items,false)
        return binding.root
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")


    }
}*/