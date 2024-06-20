package com.example.movies_poa_app.viewModel

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.launch

class PopularViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>> get() = _popularMovies

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> get() = _searchQuery

    init {
        fetchPopularMovies("your_api_key", 1)
    }

    private fun fetchPopularMovies(apiKey: String, page: Int) {
        viewModelScope.launch {
            try {
                val response: MovieResponse = repository.getPopularMovies(apiKey, page).blockingGet()
                _popularMovies.postValue(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchMovies(query: String) {
        _searchQuery.value = query
        if (query.isNotBlank()) {
            viewModelScope.launch {
                try {
                    val movies = repository.searchMovies(query)
                    _popularMovies.postValue(movies)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } else {
            fetchPopularMovies("your_api_key", 1)
        }
    }
}
