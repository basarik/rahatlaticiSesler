package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 26/09/18.
 */
interface FavouriteRepository {
    fun getSongs(listener: OnResponseListener<List<Song>>)
}