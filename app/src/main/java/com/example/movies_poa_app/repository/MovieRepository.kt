package com.example.movies_poa_app.repository


import com.example.movies_poa_app.retrofit.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MovieRepository(private val service: ApiService) {
    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)

    fun getNowPlaying(apiKey: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getNowPlaying(
                    apiKey,
                    "en-US",
                    1
                )
                if (response.isSuccessful) {

                } else {

                }
            } catch (e: Exception) {

            }
        }
    }

}


