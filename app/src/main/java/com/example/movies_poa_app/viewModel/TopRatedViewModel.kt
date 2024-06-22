//package com.example.movies_poa_app.viewModel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.movies_poa_app.model.Movie
//import com.example.movies_poa_app.repository.MovieRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class TopRatedViewModel(private val movieRepository: MovieRepository) : ViewModel() {
//
//    private val _movies = MutableLiveData<List<Movie>>()
//    val movies: LiveData<List<Movie>> get() = _movies
//
//    private val _moviesError = MutableLiveData<String>()
//    val moviesError: LiveData<String> get() = _moviesError
//
//    fun fetchTopRatedMovies(apiKey: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val response = movieRepository.getTopRatedMovies(apiKey)
//                _movies.postValue(response.movies)
//            } catch (e: Exception) {
//                _moviesError.postValue(e.message ?: "Unknown error occurred")
//            }
//        }
//    }
//}
