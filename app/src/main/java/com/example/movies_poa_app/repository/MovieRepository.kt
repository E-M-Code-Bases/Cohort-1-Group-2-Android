package com.example.movies_poa_app.repository

import com.example.movies_poa_app.model.MovieResponse

class MovieRepository(private val api: MovieApi) {
    fun getPopularMovies(apiKey: String, page: Int): Single<MovieResponse> {
        return api.getPopularMovies(apiKey, page)
    }
}

