package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class TopRatedViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    init {
        fetchTopRatedMovies()
    }

    private fun fetchTopRatedMovies() {
        viewModelScope.launch (Dispatchers.IO){
            val response = repository.getTopRatedMovies("a46d79ac5127fe803aabf6513cafe146")
           _movies.postValue(response.)
        }

   }
}

