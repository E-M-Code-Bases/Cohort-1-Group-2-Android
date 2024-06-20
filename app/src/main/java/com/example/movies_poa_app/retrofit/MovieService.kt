package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.model.TopRatedMoviesResponse
import com.example.movies_poa_app.model.UpcomingMovie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/movie/upcoming")
    suspend fun getUpcoming(@Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String): UpcomingMovie
}

interface ApiService {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("a46d79ac5127fe803aabf6513cafe146") apiKey: String): TopRatedMoviesResponse
}
