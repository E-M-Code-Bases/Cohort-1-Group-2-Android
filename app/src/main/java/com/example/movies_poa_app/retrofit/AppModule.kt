package com.example.movies_poa_app.retrofit

import com.example.movies_poa_app.repository.MovieRepository
import com.example.movies_poa_app.viewModel.FavouritesViewModel
import com.example.movies_poa_app.viewModel.PopularViewModel
import com.example.movies_poa_app.viewModel.NowPlayingViewModel
import com.example.movies_poa_app.viewModel.ShowDetailsViewModel
import com.example.movies_poa_app.viewModel.TopRatedViewModel
import com.example.movies_poa_app.viewModel.TrailerViewModel
import com.example.movies_poa_app.viewModel.UpcomingViewModel
import okhttp3.Interceptor

import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
val baseUrl = "https://api.themoviedb.org/3/"
val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5OWNjMTMyZGJhODM0ZTRlNTZlYWZkYWNhMzgyYjJkZCIsInN1YiI6IjY2NjkzYzE2ZTcxMDM0MDEwZmJlYWE1OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.s2yy6z0a1ZRt05q25ZZ34dugk3MTedmTOUfkzvMb_uE"

class AppModule {

    fun apiService(): ApiService {
        val tokenIntercepter = TokenIntercepter(API_KEY)
        val client = OkHttpClient.Builder().addInterceptor(tokenIntercepter).build()


        val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
        return api
    }
}

class TokenIntercepter(val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder().addHeader("Authorization", "Bearer $apiKey").build()
        return chain.proceed(request)
    }

}


//val networkModule = module {
//    single {
//        Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .client(okHttpClient)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//}

//val repositoryModule = module {
//    single { MovieRepository(get()) }
//}

//val viewModelModule = module {
//    viewModel { FavouritesViewModel(get()) }
//    viewModel { PopularViewModel(get()) }
//    viewModel { NowPlayingViewModel(get())}
//    viewModel { TopRatedViewModel(get())}
//    viewModel { TrailerViewModel(get()) }
//    viewModel { UpcomingViewModel(get()) }
//    viewModel { ShowDetailsViewModel(get()) }
//}
