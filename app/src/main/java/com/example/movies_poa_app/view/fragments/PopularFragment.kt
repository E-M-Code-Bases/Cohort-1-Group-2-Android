package com.example.movies_poa_app.view.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_poa_app.databinding.FragmentPopularBinding
import com.example.movies_poa_app.adapters.MoviesAdapter
import com.example.movies_poa_app.viewModel.PopularViewModel

class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding
    private val viewModel: PopularViewModel by viewModels()
    private lateinit var adapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupRecyclerView()
        setupSearch()

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = MoviesAdapter()
        binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewTopRated.adapter = adapter

        viewModel.popularMovies.observe(viewLifecycleOwner, Observer { movies ->
            adapter.submitList(movies)
        })
    }

    private fun setupSearch() {
        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.searchMovies(s.toString())
            }
        })
    }
}
