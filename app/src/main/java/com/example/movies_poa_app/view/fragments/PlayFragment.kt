package com.example.movies_poa_app.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.movies_poa_app.databinding.FragmentPlayBinding
import com.example.movies_poa_app.model.Movie


private const val TAG = "movie"
class PlayFragment : Fragment() {
    private lateinit var binding: FragmentPlayBinding
    private var movie: Movie? = null
    private val args by navArgs<PlayFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)
        movie = args.movie
        Log.d(TAG, movie!!.toString())


        //bind movie to the view

        binding.movieTitle.text = movie!!.original_title

        return binding.root
    }
}