//package com.example.movies_poa_app.adapters
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