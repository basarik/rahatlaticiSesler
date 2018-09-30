package com.example.bkubuzcu.rahatlaticisesler.api

import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by bkubuzcu on 25/09/18.
 * this is created to get items with service.
 */
interface GithubService {
    /**
     * get category of songs
     */
    @GET("categories.json")
    fun getCategories(): Call<List<Category>>

    /**
     * get songs
     */
    @GET("songs.json")
    fun getSongs(): Call<List<Song>>
}