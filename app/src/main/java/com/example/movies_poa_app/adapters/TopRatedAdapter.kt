//package com.example.movies_poa_app.adapters
//
//import com.example.movies_poa_app.databinding.ItemTopmovieBinding
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.movies_poa_app.model.Movie
//
//class TopRatedAdapter : ListAdapter<Movie, TopRatedAdapter.MovieViewHolder>(DiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
//        val binding = ItemTopmovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MovieViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        val movie = getItem(position)
//        holder.bind(movie)
//    }
//
//    class MovieViewHolder(private val binding: ItemTopmovieBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(movie: Movie) {
//            binding.movie = movie
//            binding.executePendingBindings()
//        }
//    }
//
//    class DiffCallback : DiffUtil.ItemCallback<Movie>() {
//        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id
//        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
//    }
//}
