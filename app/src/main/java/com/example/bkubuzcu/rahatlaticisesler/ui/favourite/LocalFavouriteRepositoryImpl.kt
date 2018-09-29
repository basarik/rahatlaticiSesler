package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.app.App
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.room.SongDao
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by bkubuzcu on 28/09/18.
 */
class LocalFavouriteRepositoryImpl(private val dao: SongDao) : LocalFavouriteRepository {
    override fun delete(song: Song) {
        App.instance.globalFavourites.remove(song)
        doAsync { dao.delete(song) }
    }

    override fun insert(song: Song) {
        App.instance.globalFavourites.add(song)
        doAsync {
            dao.insert(song)
        }
    }

    override fun getFavourites(listener: OnLocalFavouritesListener) {
        doAsync {
            val list = dao.all
            uiThread {
                listener.onGetLocalFavourites(list)
                App.instance.globalFavourites.let {
                    it.clear()
                    it.addAll(list)
                }
            }
        }
    }
}

interface LocalFavouriteRepository {
    fun getFavourites(listener: OnLocalFavouritesListener)
    fun insert(song: Song)
    fun delete(song: Song)
}

interface OnLocalFavouritesListener {
    fun onGetLocalFavourites(list: List<Song>)
}