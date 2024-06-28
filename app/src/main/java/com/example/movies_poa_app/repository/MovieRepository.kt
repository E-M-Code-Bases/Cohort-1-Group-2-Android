package com.example.movies_poa_app.repository

import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.retrofit.ApiService
import com.example.movies_poa_app.model.FavoriteRequest
import com.example.movies_poa_app.model.MovieDetails
import com.example.movies_poa_app.model.TrailerResponse
import retrofit2.Response

class MovieRepository(private val service: ApiService) {

    fun getPopularMovies(apiKey: String): MovieResponse {
        return service.getPopularMovies(apiKey)
    }

    suspend fun searchMovies(apiKey: String, query: String): MovieResponse {
        return service.searchMovies(apiKey, query)
    }

    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)


    suspend fun getTopRatedMovies() :Response<MovieResponse>{
        ///return null
        return service.getTopRatedMovies()
    }

    suspend fun getNowPlaying(

    ): Response<MovieResponse> {
        return service.getNowPlaying()
    }

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

    suspend fun getTrailer(apiKey: Int, movieId: String): Response<TrailerResponse> {
        return service.getTrailers(apiKey, movieId)
    }

    suspend fun  showDetails(apiKey: String,movieId: Int):Response<MovieDetails>{
        return  service.showDetail(movieId,apiKey)
    }
}







