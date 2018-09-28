package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.room.SongDao
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by bkubuzcu on 28/09/18.
 */
class LocalFavouriteRepositoryImpl(private val dao: SongDao) : LocalFavouriteRepository {
    override fun insertAll(list: List<Song>) {
        doAsync {
            dao.insertAll(list)
        }
    }

    override fun getFavourites(listener: OnLocalFavourites) {
        doAsync {
            val list = dao.all
            uiThread {
                listener.onGetLocalFavourites(list)
            }
        }
    }
}

interface LocalFavouriteRepository {
    fun getFavourites(listener: OnLocalFavourites)
    fun insertAll(list: List<Song>)
}

interface OnLocalFavourites {
    fun onGetLocalFavourites(list: List<Song>)
}