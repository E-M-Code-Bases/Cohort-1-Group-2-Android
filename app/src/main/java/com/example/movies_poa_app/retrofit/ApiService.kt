package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.model.FavoriteRequest
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
    suspend fun getTopRatedMovies(@Query("a46d79ac5127fe803aabf6513cafe146") apiKey: String): Response<MovieResponse>


    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavoriteMovies(@Path("account_id") accountId: Int, @Query("api_key") apiKey: String, @Query("session_id") sessionId: String): Response<MovieResponse>

    @POST("account/{account_id}/favorite")
    suspend fun addFavoriteMovie(@Path("account_id") accountId: Int, @Query("api_key") apiKey: String, @Query("session_id") sessionId: String, @Body favoriteRequest: FavoriteRequest): Response<Unit>


    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("api_key") apiKey: String,@Query("language") language: String, @Query("page") page: Int): Response<MovieResponse>

    @GET("movie/{movie_id}/videos")
    suspend fun getTrailers(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String): Response<TrailerResponse>
}


