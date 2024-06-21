package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.viewModel.FavouritesViewModel
import com.example.movies_poa_app.viewModel.PopularViewModel
import com.example.movies_poa_app.viewModel.NowPlayingViewModel
import com.example.movies_poa_app.viewModel.TopRatedViewModel

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val baseUrl = "https://api.themoviedb.org/3/"

val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { MovieRepository(get()) }
}

val viewModelModule = module {
    viewModel { FavouritesViewModel(get()) }
    viewModel { PopularViewModel(get()) }
    viewModel { NowPlayingViewModel(get())}
    viewModel { TopRatedViewModel(get())}
}
