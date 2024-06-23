package com.example.movies_poa_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.MovieDetails
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class  ShowDetailsViewModel(private  val  repository :MovieRepository):ViewModel() {

    private val _details = MutableLiveData<MovieDetails?>()
    val details: MutableLiveData<MovieDetails?> get() = _details

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchDetails(movie_id: Int, apikey: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.showDetails(apikey, movie_id)
                if (response.isSuccessful) {
                    val movieDetails = response.body()
                    if (movieDetails != null) {
                        _details.postValue(movieDetails)
                    } else {
                        _error.postValue("Response Body is null")
                    }
                } else {
                    val errorMessage =
                        "Failed to fetch movie details: ${response.errorBody()?.string()}"
                    _error.postValue(errorMessage)
                }
            } catch (e: Exception) {
                val errorMessage = "Error: ${e.message}"
                _error.postValue(errorMessage)
            }
        }
    }
}



