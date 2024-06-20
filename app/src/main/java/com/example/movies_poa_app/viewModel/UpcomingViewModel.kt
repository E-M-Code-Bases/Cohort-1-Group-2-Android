//package com.example.movies_poa_app.viewModel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.movies_poa_app.model.Movie
//import com.example.movies_poa_app.model.MovieResponse
//import com.example.movies_poa_app.model.UpcomingMovie
//import com.example.movies_poa_app.repository.MovieRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//
//class UpcomingViewModel(private val repository: MovieRepository) : ViewModel() {
//    val UpcomingMovie = mutableListOf<Movie>()
//
//    fun fetchUpcomingMovie(apiKey: String) {
//        viewModelScope.launch {
//            val response = withContext(Dispatchers.IO) {
//                repository.getUpcoming(apiKey)
//            }
//            UpcomingMovie.addAll(response.results)
//        }
//
//    }
//
//}
//
//
