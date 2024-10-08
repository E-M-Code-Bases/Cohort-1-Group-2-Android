package com.example.movies_poa_app.repository

import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.retrofit.ApiService
import com.example.movies_poa_app.model.FavoriteRequest
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.model.TrailerResponse
import retrofit2.HttpException
import retrofit2.Response

class MovieRepository(private val service: ApiService) {


    suspend fun getTopRatedMovies(apiKey: String): Response<MovieResponse>{
        return service.getTopRatedMovies(apiKey)
    }

    suspend fun getPopularMovies(): MovieResponse {
        return service.getPopularMovies()
    }

    suspend fun searchMovies(apiKey: String, query: String): MovieResponse {
        return service.searchMovies(apiKey, query)
    }

    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)

   suspend fun getNowPlaying(): Response<MovieResponse>{
       return service.getNowPlaying()
   }

    suspend fun addFavoriteMovie(accountId: String, authHeader: String, movie: Movie) {
        val request = FavoriteRequest(media_type = "movie", media_id = movie.id, favorite = true)
        val response = service.addFavoriteMovie(accountId, authHeader, request)
        if (!response.isSuccessful) throw HttpException(response)

    }

    suspend fun removeFavorite(accountId: String, authHeader: String, movieId: Int) {
        val request = FavoriteRequest(media_type = "movie", media_id = movieId, favorite = false)
        val response = service.addFavoriteMovie(accountId, authHeader, request)
        if (!response.isSuccessful) throw HttpException(response)
    }


    suspend fun getTrailer(movieId: Int): Response<TrailerResponse> {
        return service.getTrailers(movieId)
    }


    suspend fun isFavorite(accountId: String, authHeader: String, movieId: Int): Boolean {
        val response = service.getFavoriteMovies(accountId,authHeader)
        if (response.isSuccessful) {
            val favoriteMovies = response.body()?.results ?: emptyList()
            return favoriteMovies.any { it.id == movieId }
        }
        return false
    }

    suspend fun getFavouriteMovies(
        accountId: String, authHeader: String
    ): Response<MovieResponse> {
        return service.getFavoriteMovies(accountId,authHeader)


    }
}








