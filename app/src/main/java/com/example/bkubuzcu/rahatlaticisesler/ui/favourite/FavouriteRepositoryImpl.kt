package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.api.GithubService
import com.example.bkubuzcu.rahatlaticisesler.app.Constants
import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by bkubuzcu on 26/09/18.
 */
class FavouriteRepositoryImpl(private val service: GithubService) : FavouriteRepository {
    override fun getSongs(listener: OnResponseListener<List<Song>>) {
        service.getFavourites().enqueue(object : Callback<List<Song>?> {
            override fun onFailure(call: Call<List<Song>?>?, t: Throwable) {
                listener.onResponse(ApiResponse.error(t))
            }

            override fun onResponse(call: Call<List<Song>?>?, response: Response<List<Song>?>) {
                if (response.body() != null && response.code() == Constants.RESPONSE_SUCCESS_CODE) {
                    listener.onResponse(ApiResponse(response.body()!!))
                } else {
                    listener.onResponse(ApiResponse.error(Throwable(Constants.ERROR_OCCURED)))
                }
            }
        })
    }

}

interface FavouriteRepository {
    fun getSongs(listener: OnResponseListener<List<Song>>)
}