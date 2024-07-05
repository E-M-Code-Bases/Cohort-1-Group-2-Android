//package com.example.movies_poa_app.view.fragments
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.movies_poa_app.R
//import com.example.movies_poa_app.viewModel.FavouritesViewModel
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.Observer
//import com.example.movies_poa_app.adapters.FavouritesAdapter
//import com.example.movies_poa_app.adapters.MovieClickListener
//import com.example.movies_poa_app.databinding.FragmentFavouritesBinding
//import com.example.movies_poa_app.model.Movie
//import com.example.movies_poa_app.repository.MovieRepository
//import com.example.movies_poa_app.retrofit.ApiService
//import com.example.movies_poa_app.retrofit.AppModule
//
//class FavouritesFragment : Fragment(), MovieClickListener {
//
//    private lateinit var binding: FragmentFavouritesBinding
//
//    private lateinit var adapter: FavouritesAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourites, container, false)
//        val service = AppModule().apiService()
//
//        val repo = MovieRepository(service)
//
////        val viewModel: FavouritesViewModel by viewModels {
////            FavoriteModelProvider(repo)
////        }
//        binding.lifecycleOwner = viewLifecycleOwner
//
//        adapter = FavouritesAdapter(emptyList(), this)
//        binding.recyclerView.adapter = adapter
//
//        // Observe LiveData
//        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
//            movies?.let {
//                adapter.updateMovies(it)
//            }
//        })
//
//        // Calling the  getFavoriteMovies method  from  the viewmodel to fetch data
//        viewModel.getFavoriteMovies(accountId = 1, apiKey = "....", sessionId = "......")
//
//        return binding.root
//    }
//
//    override fun onMovieClick(movie: Movie) {
//        //will handle the click event to play the movie  on click
//    }
//}
