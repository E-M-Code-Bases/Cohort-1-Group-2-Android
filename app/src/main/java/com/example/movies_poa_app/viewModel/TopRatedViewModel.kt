package com.example.movies_poa_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.TopRatedMoviesResponse
import com.example.movies_poa_app.model.TopRatedMovies
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class TopRatedViewModel(private val repository: MovieRepository) : ViewModel() {
    private val topRatedMovies = mutableListOf<TopRatedMovies>()

    fun fetchTopRatedMovies(apiKey: String) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
            repository.getTopRatedMovies("a46d79ac5127fe803aabf6513cafe146")
           }
            TopRatedMovies.addAll(response.results)
        }

   }
}

