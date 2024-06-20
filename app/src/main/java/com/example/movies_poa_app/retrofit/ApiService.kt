package com.example.movies_poa_app.retrofit
import com.example.movies_poa_app.model.FavoriteRequest
import com.example.movies_poa_app.model.Movie
import com.example.movies_poa_app.model.MovieResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/movie/upcoming")
    suspend fun getUpcoming(@Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String): Movie



    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavoriteMovies(
        @Path("account_id") accountId: Int,
        @Query("api_key") apiKey: String,
        @Query("session_id") sessionId: String): Response<MovieResponse>

    @POST("account/{account_id}/favorite")
    suspend fun addFavoriteMovie(
        @Path("account_id") accountId: Int,
        @Query("api_key") apiKey: String,
        @Query("session_id") sessionId: String,
        @Body favoriteRequest: FavoriteRequest): Response<Unit>

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MovieResponse>

}


