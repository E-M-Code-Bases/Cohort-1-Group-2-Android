package com.example.movies_poa_app.repository

import android.graphics.Movie
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.retrofit.ApiService
import com.example.movies_poa_app.model.FavoriteRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieRepository(private val service: ApiService) {

    fun getPopularMovies(apiKey: String, page: Int): MovieResponse {
        return service.getPopularMovies(apiKey, page)
    }

    suspend fun searchMovies(apiKey: String, query: String): MovieResponse {
        val response = service.searchMovies(apiKey, query)
        return response
    }


    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)
    suspend fun getTopRatedMovies(apiKey: String) = service.getTopRatedMovies(apiKey)


    fun getNowPlaying(apiKey: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getNowPlaying(
                    apiKey,
                    "en-US",
                    1
                )
                if (response.isSuccessful) {

                } else {

                }
            } catch (e: Exception) {

            }
        }

        suspend fun getFavoriteMovies(
            accountId: Int,
            apiKey: String,
            sessionId: String
        ): Response<MovieResponse> {
            return service.getFavoriteMovies(accountId, apiKey, sessionId)

        }

        suspend fun addFavoriteMovie(
            accountId: Int,
            apiKey: String,
            sessionId: String,
            movieId: Int
        ): Response<Unit> {
            val favoriteRequest = FavoriteRequest(
                media_type = "movie",
                media_id = movieId,
                favorite = true
            )
            return service.addFavoriteMovie(accountId, apiKey, sessionId, favoriteRequest)

        }

    }
}