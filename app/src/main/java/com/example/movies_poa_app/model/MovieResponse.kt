package com.example.movies_poa_app.model

data class MovieResponse (
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)