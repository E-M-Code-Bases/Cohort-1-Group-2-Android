package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.launch

class PopularViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>> get() = _popularMovies

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> get() = _searchQuery

    private var currentPage = 1

    init {
        fetchPopularMovies("c86b2436b1121f1894caf99d7c17452d")
    }

    fun fetchPopularMovies(apiKey: String ) {
        viewModelScope.launch {
            try {
                val response: MovieResponse = repository.getPopularMovies(apiKey)
                _popularMovies.postValue(response.results)
                currentPage++
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
                    val response = repository.searchMovies("c86b2436b1121f1894caf99d7c17452d",query)
                    _popularMovies.postValue(response.results)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } else {
            fetchPopularMovies("a46d79ac5127fe803aabf6513cafe146")
        }
    }
}
