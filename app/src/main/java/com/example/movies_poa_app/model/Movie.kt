package com.example.movies_poa_app.model

import com.squareup.moshi.Json

data class Movie(
    val id: Int,
    val original_title: String,
    val overview: String,
    val release_date: String,
    val poster_path: String
)
data class TopRatedMovies(
    val id: Int,
    val title: String,
    val overview: String,
    val posterpath: String,
    val voteaverage: Double
)

data class TopRatedMoviesResponse(
    val results: List<Movie>
)


data class FavoriteRequest(
    val media_type: String,
    val media_id: Int,
    val favorite: Boolean
)

data class MovieResponse (
    val results: List<Movie>
)
