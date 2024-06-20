package com.example.movies_poa_app.repository

import android.graphics.Movie
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.retrofit.ApiService
import io.reactivex.rxjava3.core.Single

class MovieRepository(private val service: ApiService) {

    suspend fun getUpcoming(apiKey: String) {
        return service.getUpcoming(apiKey)
    }

    fun getPopularMovies(apiKey: String, page: Int): Single<MovieResponse> {
        return service.getPopularMovies(apiKey, page)
    }
    suspend fun searchMovies(apiKey: String, query: String): List<Movie> {
        val response = service.searchMovies(apiKey, query)
        return response.results
    }


}
