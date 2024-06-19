package com.example.movies_poa_app.model

data class UpcomingMovie(
    val id: Int,
    val original_title: String,
    val overview: String,
    val release_date: String,
    val poster_path: String
)
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterpath: String,
    val voteaverage: Double
)

data class TopRatedMoviesResponse(
    val results: List<Movie>
)
