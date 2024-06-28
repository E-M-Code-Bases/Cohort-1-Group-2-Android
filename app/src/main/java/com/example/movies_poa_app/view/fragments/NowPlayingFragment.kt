package com.example.movies_poa_app.view.fragments
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_poa_app.adapters.NowPlayingAdapter
import com.example.movies_poa_app.databinding.FragmentNowPlayingBinding
import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.retrofit.AppModule

import com.example.movies_poa_app.viewModel.NowPlayingViewModel
import com.example.movies_poa_app.viewModel.RatedProvider
import com.example.movies_poa_app.viewModel.TopRatedProvider
import com.example.movies_poa_app.viewModel.TopRatedViewModel
private const val TAG = "rated1"

class NowPlayingFragment : Fragment() {
    private lateinit var binding: FragmentNowPlayingBinding
    private lateinit var adapter: NowPlayingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNowPlayingBinding.inflate(inflater, container, false)
        val service = AppModule().apiService()
        val repo = MovieRepository(service)


        val viewModel: NowPlayingViewModel by viewModels {
            RatedProvider(repo)
        }
        Log.d(TAG, "oyaaaaaaaaaaa")

        viewModel.nowPlayingMovies.observe(viewLifecycleOwner) { movies ->
            adapter = NowPlayingAdapter(requireContext(), movies)
            binding.nowplayingRecyclerview.layoutManager = LinearLayoutManager(requireContext())
            binding.nowplayingRecyclerview.adapter = adapter
        }

        return binding.root
    }

}
