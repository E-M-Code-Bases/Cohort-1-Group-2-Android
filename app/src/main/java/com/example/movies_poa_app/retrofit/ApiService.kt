package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.model.FavoriteRequest
import com.example.movies_poa_app.model.TrailerResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Response<MovieResponse>

    @GET("movie/popular")
   suspend fun getPopularMovies(
        @Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String = "c86b2436b1121f1894caf99d7c17452d",
    ):MovieResponse
   @GET("movie/popular")
    fun getPopularMovies1(
        @Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String = "c86b2436b1121f1894caf99d7c17452d",
    ): Call<MovieResponse>


    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String)

    @GET("search/movie")
    suspend fun searchMovies(@Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String, @Query("query") query: String): MovieResponse


    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavoriteMovies(@Path("account_id") accountId: String,
                                  @Header("Authorization") authorization: String): Response<MovieResponse>


    @POST("account/{account_id}/favorite")
    suspend fun addFavoriteMovie(@Path("account_id") accountId: String,
                                 @Header("Authorization") authHeader: String,
                                 @Body favoriteRequest: FavoriteRequest): Response<Unit>



    @GET("movie/now_playing")
    suspend fun getNowPlaying( @Query("language") language: String = "en-US", @Query("page") page: Int = 1): Response<MovieResponse>

    @GET("movie/{movie_id}/videos")
    suspend fun getTrailers(@Path("movie_id") movieId: Int): Response<TrailerResponse>
}