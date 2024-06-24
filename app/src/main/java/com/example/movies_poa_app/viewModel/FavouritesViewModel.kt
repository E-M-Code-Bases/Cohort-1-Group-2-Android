package com.example.movies_poa_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouritesViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private val _addFavoriteStatus = MutableLiveData<Boolean>()
    val addFavoriteStatus: LiveData<Boolean> get() = _addFavoriteStatus

    fun getFavoriteMovies(accountId: Int, apiKey: String, sessionId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getFavouriteMovies(accountId, apiKey, sessionId)
            if (response.isSuccessful) {
                _movies.postValue(response.body()?.results)
            } else {
                _movies.postValue(emptyList())
            }
        }
    }

    fun addFavoriteMovie(accountId: Int, apiKey: String, sessionId: String, movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.addFavoriteMovie(accountId, apiKey, sessionId, movieId)
            _addFavoriteStatus.postValue(response.isSuccessful)
        }
    }
}