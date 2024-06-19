package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

        @GET("movie/popular")
        fun getPopularMovies(
            @Query("api_key") apiKey: String,
            @Query("page") page: Int
        ): Single<MovieResponse>
    }
