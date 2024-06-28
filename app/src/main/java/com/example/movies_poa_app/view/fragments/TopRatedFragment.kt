package com.example.movies_poa_app.view.fragments
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_poa_app.adapters.TopRatedAdapter
import com.example.movies_poa_app.databinding.FragmentTopRatedBinding
import com.example.movies_poa_app.model.MovieResponse
import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.retrofit.AppModule

import com.example.movies_poa_app.viewModel.TopRatedProvider
import com.example.movies_poa_app.viewModel.TopRatedViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "rated"
class TopRatedFragment : Fragment() {
    private lateinit var binding: FragmentTopRatedBinding
    private lateinit var adapter: TopRatedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        val service = AppModule().apiService()

        val repo = MovieRepository(service)


        val viewModel: TopRatedViewModel by viewModels {
            TopRatedProvider(repo)
        }
        Log.d(TAG, "oyaaaaaaaaaaa")

        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            Log.d(TAG, movies.toString())

            adapter = TopRatedAdapter(requireContext(), movies!!)
            binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerViewTopRated.adapter = adapter
        }
        return binding.root

    }

}
