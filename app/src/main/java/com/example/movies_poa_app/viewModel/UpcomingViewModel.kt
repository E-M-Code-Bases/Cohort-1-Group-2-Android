//package com.example.movies_poa_app.viewModel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.movies_poa_app.model.Movie
//import com.example.movies_poa_app.model.MovieResponse
//import com.example.movies_poa_app.model.UpcomingMovie
//import com.example.movies_poa_app.repository.MovieRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//
//class UpcomingViewModel(private val repository: MovieRepository) : ViewModel() {
//    val UpcomingMovie = mutableListOf<Movie>()
//
//    fun fetchUpcomingMovie(apiKey: String) {
//        viewModelScope.launch {
//            val response = withContext(Dispatchers.IO) {
//                repository.getUpcoming(apiKey)
//            }
//            UpcomingMovie.addAll(response.results)
//        }
//
//    }
//
//}
//
//

package com.example.movies_poa_app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UpcomingViewModel(private val repository: MovieRepository) : ViewModel() {
    val movies = MutableLiveData<List<Movie>>()
    //val movies: LiveData<List<Movie>> get() = _movies

    private val _moviesError = MutableLiveData<String>()

    init {
        fetchUpcomingMovies()
    }


   private fun fetchUpcomingMovies(){

            viewModelScope.launch {
                while (isActive) {
                    try {
                        val response = repository.getUpcoming("")
                        if (response!!.isSuccessful) {
                            movies.postValue(response.body()?.results ?: emptyList())
                        } else {
                            _moviesError.postValue(response.message())
                        }
                    } catch (e: Exception) {
                        _moviesError.postValue(e.message ?: "Unknown error occurred")
                    }
                    delay(10000L)
                }

            }
        }
    }

// class to initialize our view model instance without DI
    class UpcomingProvider(val movieRepository: MovieRepository ): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UpcomingViewModel(movieRepository) as T
        }
    }


