package com.example.movies_poa_app.view.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_poa_app.databinding.FragmentPopularBinding
import com.example.movies_poa_app.adapters.PopularAdapter
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.retrofit.AppModule
import com.example.movies_poa_app.viewModel.PopularViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularBinding.inflate(inflater, container, false)


        val adp = PopularAdapter()

        binding.recyclerViewTopRated.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adp
        }

        val service = AppModule().apiService()

        val repo = MovieRepository(service)

        val viewModel: PopularViewModel by viewModels {
            PopularViewModel.PopularProvider(repo)
        }
        val cont = requireContext()
        viewModel.popularMovies.observe(viewLifecycleOwner) { movies ->
            Log.d("movies", movies.toString())
            adp.moviesList.submitList(movies)

            binding.recyclerViewTopRated.apply {
                layoutManager = LinearLayoutManager(cont)
                adapter = adp
            }
        }
        return binding.root
    }

}

