package com.example.movies_poa_app.repository


import com.example.movies_poa_app.retrofit.ApiService


class MovieRepository(private val service: ApiService) {
    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)



}


