package com.example.movies_poa_app.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.movies_poa_app.R


@BindingAdapter("favoriteIcon")
fun setFavoriteIcon(view: ImageView, isFavorite: Boolean) {
    val drawable = if (isFavorite) {
        R.drawable.favorite_icon
    } else {
        R.drawable.favourite_border
    }
    view.setImageResource(drawable)
}