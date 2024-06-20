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
import com.example.movies_poa_app.databinding.FragmentNowPlayingBinding
import com.example.movies_poa_app.viewModel.NowPlayingViewModel

class NowPlayingFragment : Fragment() {
    private lateinit var binding: FragmentNowPlayingBinding
    private lateinit var viewModel: NowPlayingViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_now_playing,container,false)

         viewModel= ViewModelProvider(requireActivity()).get(NowPlayingViewModel::class.java)


        recyclerView= binding.nowplayingRecyclerview
        binding.nowplayingRecyclerview.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }


}