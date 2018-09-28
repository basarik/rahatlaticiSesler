package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteRepository

/**
 * Created by bkubuzcu on 26/09/18.
 */
class MockFavouriteRepository : FavouriteRepository{
    var isSuccess = true
    override fun getSongs(listener: OnResponseListener<List<Song>>) {
        if (isSuccess){
            listener.onResponse(ApiResponse.success(SONGS))
        } else{
            listener.onResponse(ApiResponse.error(Throwable(ERROR)))
        }
    }

    companion object {
        const val ERROR = "Mock Error"
        val SONGS = listOf(Song(0, "asd", 0,true, "asd", false))
    }

}