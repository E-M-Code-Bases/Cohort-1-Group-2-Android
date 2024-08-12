package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class PopularViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>> get() = _popularMovies

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> get() = _searchQuery

    private var currentPage = 1

    init {
        fetchPopularMovies()
    }

    fun fetchPopularMovies() {
        viewModelScope.launch {
            while (isActive){
                try {
                    val response: MovieResponse = repository.getPopularMovies()
                    _popularMovies.postValue(response.results)
                    currentPage++
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                delay(10000L)
            }
        }
    }
    class PopularProvider(val movieRepository: MovieRepository ): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return PopularViewModel(movieRepository) as T
        }
    }
}
