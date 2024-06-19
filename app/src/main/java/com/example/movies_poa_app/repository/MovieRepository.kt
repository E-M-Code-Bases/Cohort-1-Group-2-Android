package com.example.movies_poa_app.repository

<<<<<<< HEAD
class MovieRepository {
}

=======
import com.example.movies_poa_app.retrofit.MovieService


class MovieRepository(private val service: MovieService) {
    suspend fun getUpcoming(apiKey: String) = service.getUpcoming(apiKey)

}


>>>>>>> 5bc25671e34e43e7f5feed8992f79853d7fc2f7e
