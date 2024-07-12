package com.example.movies_poa_app.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.retrofit.API_KEY
import com.example.movies_poa_app.retrofit.account_id
import kotlinx.coroutines.launch

class FavouritesViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite


    private val _favoriteMovies = MutableLiveData<List<Movie>>()
    val favoriteMovies: LiveData<List<Movie>> get() = _favoriteMovies


    fun toggleFavorite(movie: Movie) {
        viewModelScope.launch {
            try {
                val isFavorite = _isFavorite.value ?: false
                if (isFavorite) {
                    repository.removeFavorite(account_id, "Bearer $API_KEY", movie.id)
                } else {
                    repository.addFavoriteMovie(account_id, "Bearer $API_KEY", movie)
                }
                _isFavorite.value = !isFavorite
                Log.d("FavouritesViewModelv", "Favorite status toggled: ${!isFavorite}")
            } catch (e: Exception) {
                Log.e("FavouritesViewModel", "Error toggling favorite status: ${e.message}")
            }
        }
    }


    fun fetchFavoriteMovies(accountId: String, authHeader: String) {
        viewModelScope.launch {
            try {
                val response = repository.getFavouriteMovies(accountId, authHeader)
                if (response.isSuccessful) {
                    _favoriteMovies.postValue(response.body()?.results)
                } else {
                    Log.e(
                        "FavoriteViewModel",
                        "Failed to fetch favorite movies: ${response.errorBody()?.string()}"
                    )
                }
            } catch (e: Exception) {
                Log.e("FavoriteViewModel", "Error fetching favorite movies", e)
            }
        }
    }

    class FavouritesViewModelFactory(private val repository: MovieRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FavouritesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FavouritesViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}