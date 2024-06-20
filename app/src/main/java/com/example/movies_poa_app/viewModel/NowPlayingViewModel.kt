package com.example.movies_poa_app.viewModel

import androidx.lifecycle.ViewModel
import com.example.movies_poa_app.repository.MovieRepository

class NowPlayingViewModel (private val movieRepository: MovieRepository)  : ViewModel() {


    fun fetchMovies(apiKey: String) {
        movieRepository.getNowPlaying(apiKey)

    }


}