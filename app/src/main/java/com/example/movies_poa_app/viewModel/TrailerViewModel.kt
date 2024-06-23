package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Trailer
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrailerViewModel(private  val  repository :MovieRepository) : ViewModel(){
     private  val  _trailer  = MutableLiveData<List<Trailer>>()
    val   trailer :LiveData<List<Trailer>> get() = _trailer

    private  val _error = MutableLiveData<String>()
    val  error :LiveData<String> get() = _error

    fun fetchMovieTrailers(movieId: Int, apiKey: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getTrailer(movieId,apiKey)
                if (response.isSuccessful) {
                    _trailer.postValue(response.body()?.results ?: emptyList())
                } else {
                    _error.postValue("Failed to fetch trailers: ${response.message()}")
                }
            } catch (e: Exception) {
                _error.postValue("Error: ${e.message}")
            }
        }
    }
}

