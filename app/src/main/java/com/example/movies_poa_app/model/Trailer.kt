package com.example.movies_poa_app.model

data class TrailerResponse(
    val id: Int,
    val results: List<Trailer>
)

data class Trailer(
    val id: String,
    val key: String,
    val name: String,
    val site: String,
    val type: String
)