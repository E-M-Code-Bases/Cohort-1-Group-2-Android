package com.example.movies_poa_app.viewModel

import androidx.lifecycle.ViewModel

class NowPlayingViewModel(get: Any) : ViewModel() {
    var posterPath: String = ""
    var voteAverage: Double = 0.0
    var overview: String = ""

}