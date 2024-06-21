package com.example.movies_poa_app.repository

import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.retrofit.ApiService
import com.example.movies_poa_app.model.FavoriteRequest
import com.example.movies_poa_app.model.TrailerResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieRepository(private val service: ApiService) {

    fun getPopularMovies(apiKey: String):MovieResponse {
        return service.getPopularMovies(apiKey)
    }

    suspend fun searchMovies(apiKey: String, query: String): MovieResponse {
        return service.searchMovies(apiKey, query)
    }


    }

    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)
    suspend fun getTopRatedMovies(apiKey: String) = service.getTopRatedMovies(apiKey)

    suspend fun getNowPlaying(apiKey: String, language:String,page: Int): Response<MovieResponse> {
        return service.getNowPlaying(apiKey, language,page)
        }

        suspend fun getFavouriteMovies(accountId: Int, apiKey: String, sessionId: String, ): Response<MovieResponse> {
            return service.getFavoriteMovies(accountId, apiKey, sessionId)

    suspend fun getFavouriteMovies(
        accountId: Int,
        apiKey: String,
        sessionId: String,
    ): Response<MovieResponse> {
        return service.getFavoriteMovies(accountId, apiKey, sessionId)

    }

    suspend fun addFavoriteMovie(
        accountId: Int,
        apiKey: String,
        sessionId: String,
        movieId: Int,
    ): Response<Unit> {
        val favoriteRequest =
            FavoriteRequest(media_type = "movie", media_id = movieId, favorite = true)
        return service.addFavoriteMovie(accountId, apiKey, sessionId, favoriteRequest)

    }

    suspend fun getTrailer(apiKey: String, movieId: Int): TrailerResponse {
        return service.getTrailer(apiKey, movieId)
    }
}





