package com.example.movies_poa_app.adapters

import android.content.res.Resources.NotFoundException
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movies_poa_app.view.fragments.AddFavouriteFragment
import com.example.movies_poa_app.view.fragments.ListMoviesFragment
import com.example.movies_poa_app.view.fragments.NowPlayingFragment
import com.example.movies_poa_app.view.fragments.PopularFragment
import com.example.movies_poa_app.view.fragments.ShowDetailsFragment
import com.example.movies_poa_app.view.fragments.TrailerFragment
import com.example.movies_poa_app.view.fragments.UpcomingFragment

class PagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 7
    }

    override fun createFragment(position: Int): Fragment {
return  when(position){
    0 -> {
        ListMoviesFragment()
    }
    1 -> {
        NowPlayingFragment()
    }
    2 -> {
        UpcomingFragment()
    }
    3 -> {
        PopularFragment()
    }
    4 -> {
        ShowDetailsFragment()
    }
    5 -> {
        AddFavouriteFragment()
    }
    6 -> {
        TrailerFragment()
    }
    else -> throw NotFoundException("Position Not Found")

}

    }
}