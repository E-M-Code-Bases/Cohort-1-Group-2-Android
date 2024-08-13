package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.launch

class TopRatedViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val movies = MutableLiveData<List<Movie>>()
    private val _moviesError = MutableLiveData<String>()
    val moviesError: LiveData<String> get() = _moviesError

    init {
        fetchTopRatedMovies()
    }

    private fun fetchTopRatedMovies() {
        viewModelScope.launch {
            try {
                val response = movieRepository.getTopRatedMovies()
                if (response.isSuccessful) {
                    val movieList = response.body()?.results ?: emptyList()
                    movies.postValue(movieList)
                } else {
                    _moviesError.postValue(response.message())
                }
            } catch (e: Exception) {
                _moviesError.postValue(e.message ?: "Unknown error occurred")
            }
        }
    }
}

class TopRatedProvider(private val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopRatedViewModel::class.java)) {
            return TopRatedViewModel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
