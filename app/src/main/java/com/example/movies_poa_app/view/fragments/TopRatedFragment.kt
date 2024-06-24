package com.example.movies_poa_app.view.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_poa_app.adapters.TopRatedAdapter
import com.example.movies_poa_app.databinding.FragmentTopRatedBinding
import com.example.movies_poa_app.viewModel.TopRatedViewModel

class TopRatedFragment : Fragment() {
    private lateinit var binding: FragmentTopRatedBinding
    private lateinit var adapter: TopRatedAdapter
    private lateinit var viewModel: TopRatedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        viewModel.fetchTopRatedMovies(apiKey = "...")


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TopRatedAdapter(requireContext(), emptyList())
        binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTopRated.adapter = adapter

        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            adapter.updateList(movies)
        }
    }

}
