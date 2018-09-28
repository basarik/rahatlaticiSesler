package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.LocalFavouriteRepository
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.OnLocalFavourites

/**
 * Created by bkubuzcu on 28/09/18.
 */
class MockLocalFavouriteRepository : LocalFavouriteRepository {
    override fun getFavourites(listener: OnLocalFavourites) {
        listener.onGetLocalFavourites(songList)
    }

    var songList = arrayListOf<Song>()


    override fun insertAll(list: List<Song>) {
        songList.addAll(list)
    }

}