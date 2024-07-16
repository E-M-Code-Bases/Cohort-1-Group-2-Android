package com.example.movies_poa_app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies_poa_app.adapters.FavouritesAdapter
import com.example.movies_poa_app.databinding.FragmentFavouritesBinding
import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.retrofit.API_KEY
import com.example.movies_poa_app.retrofit.AppModule
import com.example.movies_poa_app.retrofit.account_id
import com.example.movies_poa_app.viewModel.FavouritesViewModel

private const val TAG = "rated1"

class FavouritesFragment : Fragment() {

    private lateinit var binding: FragmentFavouritesBinding
    private lateinit var adapter: FavouritesAdapter
    private val viewModel: FavouritesViewModel by viewModels {
        FavouritesViewModel.FavouritesViewModelFactory(MovieRepository(AppModule().apiService()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        // Initialize the adapter with an empty list
        adapter = FavouritesAdapter(requireContext(), emptyList())

        binding.favouritesrecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.favouritesrecyclerView.adapter = adapter

        viewModel.favoriteMovies.observe(viewLifecycleOwner, Observer { movies ->
            movies?.let {
                adapter.movies = it
                adapter.notifyDataSetChanged()
            }
        })

        viewModel.fetchFavoriteMovies(account_id, "Bearer $API_KEY")

        return binding.root
    }
}
