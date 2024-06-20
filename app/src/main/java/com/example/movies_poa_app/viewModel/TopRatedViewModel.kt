package com.example.movies_poa_app.viewModel

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.retrofit.TMDBApiService
import kotlinx.coroutines.launch


class TopRatedViewModel(
    private val TMDBapiService: TMDBApiService) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    init {
        fetchTopRatedMovies()
    }

    private fun fetchTopRatedMovies() {
        viewModelScope.launch {
            try {
                val response = TMDBapiService.getTopRatedMovies("a46d79ac5127fe803aabf6513cafe146")
                _movies.value = response.results
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}


