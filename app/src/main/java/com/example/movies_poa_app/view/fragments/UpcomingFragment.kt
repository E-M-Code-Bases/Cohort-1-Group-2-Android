package com.example.movies_poa_app.view.fragments
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_poa_app.R
import com.example.movies_poa_app.adapters.TopRatedAdapter
import com.example.movies_poa_app.adapters.UpcomingAdapter
import com.example.movies_poa_app.databinding.FragmentTopRatedBinding
import com.example.movies_poa_app.databinding.FragmentUpcomingBinding
import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.retrofit.AppModule
import com.example.movies_poa_app.viewModel.TopRatedProvider
import com.example.movies_poa_app.viewModel.TopRatedViewModel
import com.example.movies_poa_app.viewModel.UpcomingProvider
import com.example.movies_poa_app.viewModel.UpcomingViewModel



private const val TAG = "rated"
class UpcomingFragment : Fragment() {
    private lateinit var binding: FragmentUpcomingBinding
    private lateinit var adp: UpcomingAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUpcomingBinding.inflate(inflater, container, false)
        //get views by id


        val service = AppModule().apiService()

        val repo = MovieRepository(service)

        val viewModel: UpcomingViewModel by viewModels<UpcomingViewModel> {
            UpcomingProvider(repo)
        }

        Log.d(TAG, "oyaaaaaaaaaaa")


        viewModel.movies.observe(viewLifecycleOwner) {  upcomingMovies ->
            Log.d(TAG, upcomingMovies.toString())

            if(upcomingMovies.isNotEmpty()){

                adp = UpcomingAdapter(requireContext(), upcomingMovies!!)

                binding.recyclerViewUpcoming.apply{
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = adp
                }
            }

        }

        return binding.root

    }

}