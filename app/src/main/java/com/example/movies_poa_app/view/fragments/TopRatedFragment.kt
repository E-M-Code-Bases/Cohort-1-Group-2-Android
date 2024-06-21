package com.example.movies_poa_app.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_poa_app.R
import com.example.movies_poa_app.adapters.TopRatedAdapter
import com.example.movies_poa_app.databinding.FragmentTopRatedBinding
import com.example.movies_poa_app.viewModel.TopRatedViewModel

class TopRatedFragment : Fragment() {
    private lateinit var binding: FragmentTopRatedBinding
    private val viewModel: TopRatedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_rated, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.recyclerViewTopRated
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TopRatedAdapter()
        recyclerView.adapter = adapter

//        viewModel.movie.observe(viewLifecycleOwner) { movieList ->
//            movieList?.let {
//                adapter.submitList(it)
//            }
//        }

    }
}
