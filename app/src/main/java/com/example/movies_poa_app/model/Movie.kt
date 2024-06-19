package com.example.movies_poa_app.model

import android.graphics.Movie


data class MovieResponse(
    val results: List<Movie>
)
data class PopularMovie(
    val id: Int,
    val original_title: String,
    val overview: String,
    val release_date: String,
    val poster_path: String
)