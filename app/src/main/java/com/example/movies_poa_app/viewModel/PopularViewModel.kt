package com. .movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_poa_app.adapters.PagerAdapter
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.repository.MovieRepository
import kotlinx.coroutines.launch

class PopularViewModel(private val repository: MovieRepository) : ViewModel() {
    private val popularMovies = MutableLiveData<MovieResponse>()
    val adapter = PagerAdapter()

    fun fetchPopularMovies(apiKey: String) {
        viewModelScope.launch {
            val response = repository.getPopularMovies(apiKey)
            popularMovies.postValue(response)
            adapter.submitList(response.results)
        }
    }
}
