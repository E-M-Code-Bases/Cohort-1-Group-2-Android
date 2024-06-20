package com.example.movies_poa_app.model


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
