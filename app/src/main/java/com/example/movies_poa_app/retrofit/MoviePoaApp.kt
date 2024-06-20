package com.example.movies_poa_app.retrofit
import android.app.Application
import org.koin.core.context.startKoin

class MoviePoaApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}

