package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
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

class TopRatedViewModel(private val movieRepository: MovieRepository) : ViewModel() {

     val movies = MutableLiveData<List<Movie>>()
    //val movies: LiveData<List<Movie>> get() = _movies

    private val _moviesError = MutableLiveData<String>()
    init{
        fetchTopRatedMovies()
    }


    private fun fetchTopRatedMovies() {
        viewModelScope.launch {
           while (isActive){
               try {
                   val response = movieRepository.getTopRatedMovies()
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

class TopRatedProvider(val movieRepository: MovieRepository ): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TopRatedViewModel(movieRepository) as T
    }
}
