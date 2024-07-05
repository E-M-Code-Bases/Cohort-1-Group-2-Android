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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouritesViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite


//    fun getFavoriteMovies(accountId: Int, apiKey: String, sessionId: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = repository.getFavouriteMovies(accountId)
//            if (response.isSuccessful) {
//                _movies.postValue(response.body()?.results)
//            } else {
//                _movies.postValue(emptyList())
//            }
//        }
//    }


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
}

class FavouritesViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavouritesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavouritesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}