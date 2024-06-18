package com.example.movies_poa_app.repository

import com.example.movies_poa_app.retrofit.MovieService


class MovieRepository(private val service: MovieService) {
    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)

}


