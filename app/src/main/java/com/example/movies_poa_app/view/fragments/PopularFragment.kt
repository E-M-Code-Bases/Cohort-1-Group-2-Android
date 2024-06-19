package com.example.movies_poa_app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.movieapp.viewmodel.PopularViewModel
import com.example.movies_poa_app.R
import com.example.movies_poa_app.databinding.FragmentPopularBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PopularFragment : Fragment() {

    private val viewModel: PopularViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPopularBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_popular, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.fetchPopularMovies("your_api_key")

        return binding.root
    }
}
