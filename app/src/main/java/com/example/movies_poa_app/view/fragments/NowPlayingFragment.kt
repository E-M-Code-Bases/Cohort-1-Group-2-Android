package com.example.movies_poa_app.view.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_poa_app.R
import com.example.movies_poa_app.adapters.NowPlayingAdapter
import com.example.movies_poa_app.databinding.FragmentNowPlayingBinding
import com.example.movies_poa_app.viewModel.NowPlayingViewModel

class NowPlayingFragment : Fragment() {
    private lateinit var binding: FragmentNowPlayingBinding
    private lateinit var adapter: NowPlayingAdapter
    private lateinit var viewModel: NowPlayingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNowPlayingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NowPlayingAdapter(requireContext(), emptyList())
        binding.nowplayingRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.nowplayingRecyclerview.adapter = adapter

        viewModel.nowPlayingMovies.observe(viewLifecycleOwner) { movies ->
            adapter.updateList(movies)
        }

        viewModel.fetchNowPlaying("", "en-US", 1)

    }
}
