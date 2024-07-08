//package com.example.movies_poa_app.view.fragments
//
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.movies_poa_app.adapters.FavouritesAdapter
//import com.example.movies_poa_app.adapters.NowPlayingAdapter
//import com.example.movies_poa_app.databinding.FragmentFavouritesBinding
//import com.example.movies_poa_app.databinding.FragmentNowPlayingBinding
//import com.example.movies_poa_app.repository.MovieRepository
//import com.example.movies_poa_app.retrofit.AppModule
//import com.example.movies_poa_app.viewModel.FavouritesViewModel
//import com.example.movies_poa_app.viewModel.FavouritesViewModelFactory
//import com.example.movies_poa_app.viewModel.NowPlayingProvider
//import com.example.movies_poa_app.viewModel.NowPlayingViewModel
//
//private const val TAG = "rated1"
//
//class FavouritesFragment : Fragment() {
//    private lateinit var binding: FragmentFavouritesBinding
//    private lateinit var adapter: FavouritesAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding =  FragmentFavouritesBinding.inflate(inflater, container, false)
//        val service = AppModule().apiService()
//        val repo = MovieRepository(service)
//
//
//        val viewModel: FavouritesViewModel by viewModels {
//            FavouritesViewModelFactory(repo)
//        }
//        Log.d(TAG, "oyaaaaaaaaaaa")
//
//        viewModel.isFavorite.observe(viewLifecycleOwner) { movies ->
//            adapter = FavouritesAdapter(requireContext(), movies)
//            binding.favouritesrecyclerView.layoutManager = LinearLayoutManager(requireContext())
//            binding.favouritesrecyclerView.adapter = adapter
//        }
//
//        return binding.root
//    }
//
//}
