package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.model.FavoriteRequest
import com.example.movies_poa_app.model.MovieDetails
import com.example.movies_poa_app.model.TrailerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String,
    ):MovieResponse


    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String)

    @GET("search/movie")
    suspend fun searchMovies(@Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String, @Query("query") query: String): MovieResponse


    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): Response<MovieResponse>


    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavoriteMovies(@Path("account_id") accountId: Int, @Query("de95d5e165747c38cab2df155c80bcd7") apiKey: String, @Query("session_id") sessionId: String): Response<MovieResponse>

    @POST("account/{account_id}/favorite")
    suspend fun addFavoriteMovie(@Path("account_id") accountId: Int, @Query("de95d5e165747c38cab2df155c80bcd7") apiKey: String, @Query("session_id") sessionId: String, @Body favoriteRequest: FavoriteRequest): Response<Unit>


    @GET("movie/popular")
    suspend fun getNowPlaying( @Query("language") language: String = "en-US", @Query("page") page: Int = 1): Response<MovieResponse>

    @GET("movie/{movie_id}/videos")
    suspend fun getTrailers(@Path("movie_id") movieId: Int, @Query("de95d5e165747c38cab2df155c80bcd7") apiKey: String): Response<TrailerResponse>


    @GET("movie/{movie_id}")
    suspend fun showDetail(@Path("movie_id") movie_id: Int, @Query("de95d5e165747c38cab2df155c80bcd7")
    apiKey: String):Response<MovieDetails>
}


