package com.example.movies_poa_app.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.movies_poa_app.databinding.FragmentPlayBinding
import com.example.movies_poa_app.model.Movie
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

private const val TAG = "movie"
private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"

class PlayFragment : Fragment() {
    private lateinit var binding: FragmentPlayBinding
    private var movie: Movie? = null
    private val args by navArgs<PlayFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayBinding.inflate(inflater, container, false)
        movie = args.movie
        Log.d(TAG, "Movie: $movie")

        // Bind movie data to views
        movie?.let { bindViews(it) } ?: Log.e(TAG, "Movie data is null")

        return binding.root
    }


    private fun bindViews(movie: Movie) {
        val imageUrl = BASE_IMAGE_URL + movie.poster_path
        // Load the movie poster using Picasso with error logging
        Picasso.get().load(imageUrl).into(binding.moviePoster, object : Callback {
            override fun onSuccess() {
                Log.d(TAG, "Image loaded successfully")
            }

            override fun onError(e: Exception?) {
                Log.e(TAG, "Error loading image", e)
            }
        })

        binding.movieTitle.text = movie.original_title
        Log.d(TAG, "Title set: ${movie.original_title}")

        binding.movieReleaseDate.text= movie.release_date
        Log.d(TAG, "Release Date set: ${movie.release_date}")

        binding.movieRating.text = movie.vote_average.toString()
        Log.d(TAG, "Rating set: ${movie.vote_average}")

        binding.movieOverview.text= movie.overview
        Log.d(TAG, "Overview set: ${movie.overview}")
    }
}

