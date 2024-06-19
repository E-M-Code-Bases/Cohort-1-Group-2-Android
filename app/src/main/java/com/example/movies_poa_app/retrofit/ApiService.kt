package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.model.UpcomingMovie
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/movie/upcoming")
    suspend fun getUpcoming(@Query("c86b2436b1121f1894caf99d7c17452d") apiKey: String): UpcomingMovie
}