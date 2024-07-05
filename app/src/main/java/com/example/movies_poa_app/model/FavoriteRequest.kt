package com.example.movies_poa_app.model

data class FavoriteRequest(
    val media_type: String,
    val media_id: Int,
    val favorite: Boolean
)