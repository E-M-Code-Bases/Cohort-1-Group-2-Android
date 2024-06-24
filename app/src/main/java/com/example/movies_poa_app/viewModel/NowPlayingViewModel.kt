package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NowPlayingViewModel (private val movieRepository: MovieRepository)  : ViewModel() {

    private val _nowPlayingMovies = MutableLiveData<List<Movie>>()
    val nowPlayingMovies: LiveData<List<Movie>> get() = _nowPlayingMovies

    private val movieserror = MutableLiveData<String>()

    fun fetchNowPlaying(apiKey: String, language: String, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = movieRepository.getNowPlaying(apiKey, language, page)
                if (response.isSuccessful) {
                    val movies = response.body()?.results
                    _nowPlayingMovies.postValue(movies ?: emptyList())
                } else {
                    movieserror.postValue("Request failed with status ${response.code()}")
                }
            } catch (e: Exception) {
                movieserror.postValue(e.message ?: "Unknown error occurred")
            }
        }
    }

}