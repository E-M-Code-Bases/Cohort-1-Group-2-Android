package com.example.movies_poa_app.model

import com.squareup.moshi.Json

data class Movie(
    val id: Int,
    val original_title: String,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "release_date") val releaseDate: String?,
    val overview: String
)



data class FavoriteRequest(
    val media_type: String,
    val media_id: Int,
    val favorite: Boolean
)

data class MovieResponse (val results: List<Movie>)