package com.example.movies_poa_app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class NowPlayingViewModel (private val movieRepository: MovieRepository)  : ViewModel() {

  val movies = MutableLiveData<List<Movie>>()
    private val _moviesError = MutableLiveData<String>()

    init {
        fetchNowPlaying()
    }

    private fun fetchNowPlaying() {
        viewModelScope.launch {
            while (isActive){
                try {
                    val response = movieRepository.getNowPlaying()
                    if (response.isSuccessful) {
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
class NowPlayingProvider(val movieRepository: MovieRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NowPlayingViewModel(movieRepository) as T
    }
}