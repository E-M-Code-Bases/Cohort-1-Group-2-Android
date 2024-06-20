package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.model.MovieResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String,
        @Query("page") page: Int
    ): Single<MovieResponse>


    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String
    )

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String,
        @Query("query") query: String
    ): MovieResponse
}
