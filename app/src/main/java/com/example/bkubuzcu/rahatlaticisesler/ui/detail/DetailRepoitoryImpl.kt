package com.example.bkubuzcu.rahatlaticisesler.ui.detail

import com.example.bkubuzcu.rahatlaticisesler.api.GithubService
import com.example.bkubuzcu.rahatlaticisesler.app.Constants
import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by bkubuzcu on 28/09/18.
 */
class DetailRepoitoryImpl(private val service: GithubService) : DetailRepository {
    override fun getSongs(listener: OnResponseListener<List<Song>>, category: Category) {
        service.getSongs().enqueue(object : Callback<List<Song>?> {
            override fun onFailure(call: Call<List<Song>?>?, t: Throwable) {
                listener.onResponse(ApiResponse.error(t))
            }

            override fun onResponse(call: Call<List<Song>?>?, response: Response<List<Song>?>) {
                if (response.body() != null && response.code() == Constants.RESPONSE_SUCCESS_CODE) {
                    listener.onResponse(ApiResponse.success(response.body()!!.filter {
                        it.category == category.id
                    }))
                } else {
                    listener.onResponse(ApiResponse.error(Throwable(Constants.ERROR_OCCURED)))
                }
            }
        })
    }
}

interface DetailRepository {
    fun getSongs(listener: OnResponseListener<List<Song>>, category: Category)
}