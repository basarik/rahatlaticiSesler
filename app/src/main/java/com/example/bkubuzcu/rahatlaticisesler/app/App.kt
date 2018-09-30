package com.example.bkubuzcu.rahatlaticisesler.app

import android.app.Application
import com.example.bkubuzcu.rahatlaticisesler.api.GithubService
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.room.AppDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by bkubuzcu on 25/09/18.
 * this is application class.
 */
class App : Application() {
    /**
     * retrofit service
     */
    lateinit var service: GithubService
    /**
     * presenter factory
     */
    lateinit var presenterFactory: PresenterFactory
    /**
     * room appDatabase
     */
    lateinit var database: AppDatabase
    /**
     * retrofit base url
     */
    private val baseUrl = "https://raw.githubusercontent.com/basarik/rahatlaticiSesler/master/data/"
    /**
     * local favourite items
     * it is kept because of asynchronous operations
     */
    val globalFavourites = arrayListOf<Song>()

    override fun onCreate() {
        super.onCreate()
        instance = this

        presenterFactory = PresenterFactory()

        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(GithubService::class.java)

        database = AppDatabase.getInstance(context = applicationContext)
    }

    companion object {
        /**
         * instance of application
         */
        lateinit var instance: App
    }
}