package com.example.movies_poa_app.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_poa_app.adapters.TopRatedAdapter
import com.example.movies_poa_app.databinding.FragmentTopRatedBinding
import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.retrofit.AppModule
import com.example.movies_poa_app.viewModel.TopRatedProvider
import com.example.movies_poa_app.viewModel.TopRatedViewModel

private const val TAG = "rated"

class TopRatedFragment : Fragment() {
    private lateinit var binding: FragmentTopRatedBinding
    private lateinit var adapter: TopRatedAdapter
    private val viewModel: TopRatedViewModel by viewModels {
        TopRatedProvider(MovieRepository(AppModule().apiService()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        setupRecyclerView()
        setupObservers()
        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = TopRatedAdapter(requireContext(), emptyList())
        binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTopRated.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            Log.d(TAG, "Movies: $movies")
            adapter.updateMovies(movies)
        }

        viewModel.moviesError.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let {
                Log.e(TAG, "Error: $it")
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
