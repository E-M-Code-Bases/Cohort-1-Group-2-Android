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










//
//import android.widget.ImageView
//import androidx.databinding.BindingAdapter
//import com.example.movies_poa_app.R
//
//@BindingAdapter("imageUrl")
//fun bindImage(imageView: ImageView, imageUrl: String?) {
//    if (!imageUrl.isNullOrEmpty()) {
//        Picasso.get()
//            .load(imageUrl)
//            .placeholder(R.drawable.ic_launcher_background)
//            .error(R.drawable.ic_launcher_background)
//            .into(imageView)
//    }
//}