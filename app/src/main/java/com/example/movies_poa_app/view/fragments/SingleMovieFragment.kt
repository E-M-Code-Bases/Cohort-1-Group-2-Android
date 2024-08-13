package com.example.movies_poa_app.view.fragments

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.movies_poa_app.adapters.PagerAdapter
import com.example.movies_poa_app.databinding.FragmentSingleMovieBinding
import com.google.android.material.tabs.TabLayoutMediator

class SingleMovieFragment : Fragment() {


    private lateinit var binding: FragmentSingleMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleMovieBinding.inflate(layoutInflater, container, false)


        binding.viewPager.adapter = PagerAdapter(requireActivity())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> "Top Rated"
                1 -> "Now Playing"
                2 -> "Upcoming"
                3 -> "Favourites"
                4 -> "Trailer"
                5 -> "Popular"

                else -> throw Resources.NotFoundException("Tab index not found")
            }
        }.attach()

            binding.searchIcon.setOnClickListener {
            Toast.makeText(requireContext(), "Search clicked", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}