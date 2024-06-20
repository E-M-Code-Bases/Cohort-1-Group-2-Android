package com.example.movies_poa_app.repository

<<<<<<< HEAD
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
=======

import com.example.movies_poa_app.model.FavoriteRequest
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.retrofit.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response



class MovieRepository(private val service: ApiService) {
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

    suspend fun getFavoriteMovies(accountId: Int, apiKey: String, sessionId: String): Response<MovieResponse> {
        return service.getFavoriteMovies(accountId, apiKey, sessionId)

    }
    suspend fun addFavoriteMovie(accountId: Int, apiKey: String, sessionId: String, movieId: Int): Response<Unit> {
        val favoriteRequest = FavoriteRequest(
            media_type = "movie",
            media_id = movieId,
            favorite = true
        )
        return service.addFavoriteMovie(accountId, apiKey, sessionId, favoriteRequest)

    }

}



>>>>>>> 196e155160e1164b789b0b4388277fbe3f5423bf
