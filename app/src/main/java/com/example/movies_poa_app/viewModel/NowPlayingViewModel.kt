package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NowPlayingViewModel (private val movieRepository: MovieRepository)  : ViewModel() {

    private val _nowPlayingMovies = MutableLiveData<List<Movie>>()
    val nowPlayingMovies: LiveData<List<Movie>> get() = _nowPlayingMovies

    private val movieserror = MutableLiveData<String>()

    init{
        fetchNowPlaying()
    }

    fun fetchNowPlaying() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = movieRepository.getNowPlaying()
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
class RatedProvider(val movieRepository: MovieRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NowPlayingViewModel(movieRepository) as T
    }
}