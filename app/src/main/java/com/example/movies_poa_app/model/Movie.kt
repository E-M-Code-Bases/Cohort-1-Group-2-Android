package com.example.movies_poa_app.model


data class Movie(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String,
    val voteAverage: Double
)

data class FavoriteRequest(
    val mediaType: String,
    val mediaId: Int,
    val favorite: Boolean
)


data class MovieResponse (val results: List<Movie>)

