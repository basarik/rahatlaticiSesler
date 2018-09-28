package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.detail.DetailRepository

/**
 * Created by bkubuzcu on 28/09/18.
 */
class MockDetailRepository : DetailRepository {
    var isSuccess = true
    var category = Category(0, "asd")
    override fun getSongs(listener: OnResponseListener<List<Song>>, category: Category) {
        if (isSuccess) {
            listener.onResponse(ApiResponse.success(SONGS))
        } else {
            listener.onResponse(ApiResponse.error(Throwable(ERROR)))
        }
    }

    companion object {
        const val ERROR = "Mock Error"
        val SONGS = listOf(Song(0, "asd", 0, true, "asd", false))
    }

}