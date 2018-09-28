package com.example.bkubuzcu.rahatlaticisesler.app

import android.app.Application
import com.example.bkubuzcu.rahatlaticisesler.api.GithubService
import com.example.bkubuzcu.rahatlaticisesler.room.AppDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by bkubuzcu on 25/09/18.
 */
class App : Application() {
    lateinit var service: GithubService
    lateinit var presenterFactory: PresenterFactory
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this
        presenterFactory = PresenterFactory()
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/basarik/rahatlaticiSesler/master/data/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(GithubService::class.java)
        database = AppDatabase.getInstance(context = applicationContext)
    }

    companion object {
        lateinit var instance: App
    }
}