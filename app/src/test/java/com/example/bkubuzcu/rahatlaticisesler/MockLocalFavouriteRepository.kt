package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.LocalFavouriteRepository
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.OnLocalFavouritesListener

/**
 * Created by bkubuzcu on 28/09/18.
 */
class MockLocalFavouriteRepository : LocalFavouriteRepository {
    var mockSongList = arrayListOf<Song>()
    var mockSong:Song? = Song(0, "asd", 0, false, "asd", false)

    override fun insert(song: Song) {
        mockSong = song
    }

    override fun delete(song: Song) {
        mockSong = null
    }

    override fun getFavourites(listener: OnLocalFavouritesListener) {
        listener.onGetLocalFavourites(mockSongList)
    }
}