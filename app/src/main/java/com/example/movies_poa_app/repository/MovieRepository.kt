package com.example.movies_poa_app.repository


import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.retrofit.ApiService
import retrofit2.Response


class MovieRepository(private val service: ApiService) {
    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)

    suspend fun getFavoriteMovies(accountId: Int, apiKey: String, sessionId: String): Response<MovieResponse> {
        return service.getFavoriteMovies(accountId, apiKey, sessionId)

    }

}


